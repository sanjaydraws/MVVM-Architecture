package com.sanjayprajapat.mvvmarchitecture.ui.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowViewModel: ViewModel() {
    val countDownFlow = flow<Int> {
        val startValue = 10
        var currentValue =startValue
        emit(startValue)
        while (currentValue>0){
            delay(1000L)
            currentValue --
            emit(currentValue) // ui will receive changes
        }
    }


    init {
        collectFlow()
    }
    // if we don't use compose state
    // to notify changes
    private fun collectFlow(){
        viewModelScope.launch {
            countDownFlow.collect{
                time ->
                println("current time  $time ")
            }
        }
    }
}