package com.sanjayprajapat.mvvmarchitecture.ui.livedata_

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sanjayprajapat.mvvmarchitecture.R
import com.sanjayprajapat.mvvmarchitecture.ui.mediator.MediatorLiveDataActivity
import com.sanjayprajapat.mvvmarchitecture.ui.mediator.MediatorViewModel

class LIveDataExampleActivity : AppCompatActivity() {
    val mViewModel by viewModels<LiveDataTransformationViewModel>()

    companion object{
        const val TAG = "LIveDataExample"
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, LIveDataExampleActivity ::class.java).apply {
//              .putExtra()
            }
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_example)

        mViewModel.usersList.observe(this, Observer {
            it?:return@Observer
            Log.d(TAG, "onCreate: usersList $it")
        })

        mViewModel.usersNames.observe(this, Observer {
            it?:return@Observer
            Log.d(TAG, "onCreate: usersNames $it")
        })

        mViewModel.userName.observe(this, Observer {
            it?:return@Observer
            Log.d(TAG, "onCreate: userName $it")
        })

        mViewModel.userNames2.observe(this, Observer {
            it?:return@Observer
            Log.d(TAG, "onCreate: userName $it")
        })
//        mViewModel.changeUserList()
    }
}