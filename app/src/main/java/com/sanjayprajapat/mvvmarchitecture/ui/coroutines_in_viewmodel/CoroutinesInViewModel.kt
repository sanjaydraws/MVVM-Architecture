package com.sanjayprajapat.mvvmarchitecture.ui.coroutines_in_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class CoroutinesInViewModel :ViewModel(){

    /**
     *  this is job for all coroutines starts by this view model
     *  if this canceled all Coroutines started by this viewmodel will be cancel
     * */
    private val viewModelJob = SupervisorJob()

    private val uiScpe = CoroutineScope(Dispatchers.Main + viewModelJob)


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    /**
     * heavy operation that can not be done in Main thread
     * */
    fun loadSortedData(){
        uiScpe.launch {

        }
    }
    // Move the execution off the main thread using withContext(Dispatchers.Default)
    suspend fun sortList() = withContext(Dispatchers.Default){
        // heavy Work
    }

}