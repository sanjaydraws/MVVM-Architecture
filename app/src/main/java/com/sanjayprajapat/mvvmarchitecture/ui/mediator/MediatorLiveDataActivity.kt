package com.sanjayprajapat.mvvmarchitecture.ui.mediator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sanjayprajapat.mvvmarchitecture.R

class MediatorLiveDataActivity : AppCompatActivity() {
    val mViewModel by viewModels<MediatorViewModel>()
    val mViewModel2 by viewModels<MediatorViewModel2>()
    val mViewModel3 by viewModels<MediatorViewModel3>()
    val mViewModel4 by viewModels<MediatorViewModel4>()

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MediatorLiveDataActivity ::class.java).apply {
//              .putExtra()
            }
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mediator_live_data)

        mViewModel.usersMed.observe(this, Observer {
            it?:return@Observer
            Log.d("usersMedTAG", "onCreate: ${it}")
        })


        mViewModel2.mediatorLiveData.observe(this, Observer {
            it?:return@Observer
            Log.d("MErger Med", "onCreate: $it")
        })

        mViewModel3.pairMediatorLiveData.observe(this, Observer {
            it?:return@Observer
            Log.d("pairMediatorLiveData", "onCreate: ${it.first} ${it.second}")

        })
        mViewModel4.tripleMediatorLiveData.observe(this, Observer {
            it?:return@Observer
            Log.d("tripleMediatorLiveData", "onCreate: ${it.first} ${it.second} ${it.third} ")

        })
        mViewModel4.changeLiveDataTwo()

        mViewModel4.switchLiveData.observe(this, Observer {
            Log.d("switchLiveData", "onCreate: ${it}")
        })
    }
}



