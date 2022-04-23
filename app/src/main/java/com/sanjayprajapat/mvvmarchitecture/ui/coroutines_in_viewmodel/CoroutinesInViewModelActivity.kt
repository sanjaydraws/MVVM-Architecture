package com.sanjayprajapat.mvvmarchitecture.ui.coroutines_in_viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjayprajapat.mvvmarchitecture.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutinesInViewModelActivity : AppCompatActivity() {
  companion object{
      @JvmStatic
      fun start(context: Context) {
          val starter = Intent(context, CoroutinesInViewModelActivity ::class.java).apply {
//              .putExtra()
          }
          context.startActivity(starter)
      }
  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_in_view_model)


    }


    fun myGlobalScope(){
        GlobalScope.launch (Dispatchers.Main.immediate){


        }
    }
}