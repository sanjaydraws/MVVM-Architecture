package com.sanjayprajapat.mvvmarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sanjayprajapat.mvvmarchitecture.databinding.ActivityMainBinding
import com.sanjayprajapat.mvvmarchitecture.ui.MainActivityObserver
import com.sanjayprajapat.mvvmarchitecture.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    val mViewModel by viewModels<MainViewModel>()

    companion object{
        const val TAG = "MAInACT"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this@MainActivity))
        binding?.apply {
            setContentView(root)
        }

        lifecycle?.addObserver(MainActivityObserver()) // add observer
        Log.d(TAG, "onCreate: OWNER")
        binding?.txtClick?.setOnClickListener {
            mViewModel.getUserData()
        }

        mViewModel.userData?.observe(this, Observer {
            it?:return@Observer
            Log.d(TAG, "onCreate: $it")
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Owner")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Owner")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Owner")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Owner")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Owner")

    }

}