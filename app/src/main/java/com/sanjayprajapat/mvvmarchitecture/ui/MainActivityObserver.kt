package com.sanjayprajapat.mvvmarchitecture.ui

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainActivityObserver:DefaultLifecycleObserver {

    companion object{
        const val TAG ="MAInACT"
    }
    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate: OBSERVER ${owner.lifecycle}")
        //return job will be cancel when destroyed
        owner.lifecycleScope.launchWhenCreated {
            Log.d(TAG, "onCreate: launchWhenCreated ${this.launch { }}")
        }
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "onStart: OBSERVER ${owner.lifecycle}")
        owner.lifecycleScope.launchWhenStarted {
            Log.d(TAG, "onStart: launchWhenStarted ${this.launch { }}")

        }
    }
    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "onResume: OBSERVER ${owner.lifecycle}")
        owner.lifecycleScope.launchWhenResumed {
            Log.d(TAG, "onResume: launchWhenResumed ${this.launch { }}")

        }
    }
    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "onPause: OBSERVER ${owner.lifecycle}")

    }
    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop: OBSERVER ${owner.lifecycle}")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "onDestroy: OBSERVER ${owner.lifecycle}")
    }


}