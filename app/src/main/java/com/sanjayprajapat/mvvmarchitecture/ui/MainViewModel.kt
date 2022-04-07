package com.sanjayprajapat.mvvmarchitecture.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjayprajapat.mvvmarchitecture.data.User
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    val userData: MutableLiveData<User>? = MutableLiveData()


    fun getUserData(){
//        viewModelScope.launch {
//         userData?.postValue(User("Justin Bieber", 23))
//        }
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("MainViewModel", "${Thread.currentThread().name} ") // DefaultDispatcher-worker-1
            userData?.postValue(User("Justin Bieber", 23))
        }
    }




}