package com.sanjayprajapat.mvvmarchitecture.ui.observable_comparison

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.sanjayprajapat.mvvmarchitecture.R
import com.sanjayprajapat.mvvmarchitecture.databinding.ActivityObservableComparisonBinding
import com.sanjayprajapat.mvvmarchitecture.ui.mediator.MediatorLiveDataActivity
import com.sanjayprajapat.mvvmarchitecture.ui.mediator.MediatorViewModel4
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ObservableComparisonActivity : AppCompatActivity() {
    var binding:ActivityObservableComparisonBinding? = null
    val mViewModel by viewModels<ObservableViewModel>()

    companion object{
        const val TAG = "ObservableActivity"
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, ObservableComparisonActivity ::class.java).apply {
//              .putExtra()
            }
            context.startActivity(starter)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObservableComparisonBinding.inflate(LayoutInflater.from(this))
        binding?.apply {
            setContentView(root)
        }

        binding?.btnLiveData?.setOnClickListener {
            mViewModel.triggeredLiveData()
        }

        binding?.btnStateFlow?.setOnClickListener {
            mViewModel.triggeredStateFlow()
        }

        binding?.btnFlow?.setOnClickListener {
           lifecycleScope.launch {
               mViewModel.triggeredFlow().collectLatest {
                   binding?.txtFlowValue?.text = it
               }
           }
        }

        binding?.btnSharedFlow?.setOnClickListener {
            mViewModel.triggeredSharedFlow()
        }
        mViewModel.liveData.observe(this){
            Log.d(TAG, "onCreate: liveData  $it")
            binding?.txtLiveDataValue?.text = it
        }

        lifecycleScope.launchWhenStarted {
            mViewModel.stateFlow.collectLatest {
                Log.d(TAG, "onCreate: stateFlow $it")
                binding?.txtStateFlowValue?.text = it
                binding?.root?.let { it1 ->
                    Snackbar.make(it1,it,Snackbar.LENGTH_LONG) }?.show()

            }
        }
        lifecycleScope.launchWhenStarted {
            mViewModel.sharedFlow.collectLatest {
                binding?.txtSharedFlowValue?.text = it
                binding?.root?.let {
                        it1 -> Snackbar.make(it1,it,Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}