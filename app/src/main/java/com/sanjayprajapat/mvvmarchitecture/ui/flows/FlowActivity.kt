package com.sanjayprajapat.mvvmarchitecture.ui.flows

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.sanjayprajapat.mvvmarchitecture.R
import com.sanjayprajapat.mvvmarchitecture.databinding.ActivityFlowBinding
import com.sanjayprajapat.mvvmarchitecture.databinding.ActivityMainBinding
import com.sanjayprajapat.mvvmarchitecture.ui.mediator.MediatorLiveDataActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class FlowActivity : AppCompatActivity() {
    var binding:ActivityFlowBinding? = null
    val viewModel by viewModels<FlowViewModel> ()
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, FlowActivity ::class.java).apply {
//              .putExtra()
            }
            context.startActivity(starter)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)
        binding = ActivityFlowBinding.inflate(LayoutInflater.from(this@FlowActivity))
        binding?.apply {
            setContentView(root)
        }

        // when use compose
//        viewModel.countDownFlow.collectAsState(initial = 10)


    }
}