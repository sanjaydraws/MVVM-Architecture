package com.sanjayprajapat.mvvmarchitecture.ui.observable_comparison

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ObservableViewModel :ViewModel(){

    private val _liveData  = MutableLiveData("Hello World ")
    val liveData:LiveData<String> = _liveData


    private val _stateFlow = MutableStateFlow("Hello World Whats going on?")
    val stateFlow  = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun triggeredLiveData(){
        _liveData.value = "this is LiveData Value "
    }
    fun triggeredStateFlow(){
        _stateFlow.value = "this is State Flow "
    }
    fun triggeredFlow(): Flow<String> {
        return flow {
            repeat(5){
                emit("Item $it")
                kotlinx.coroutines.delay(1000L)
            }
        }

    }
    fun triggeredSharedFlow(){
        viewModelScope.launch {
            _sharedFlow.emit("This is Shared Flow Value")
        }

    }
}