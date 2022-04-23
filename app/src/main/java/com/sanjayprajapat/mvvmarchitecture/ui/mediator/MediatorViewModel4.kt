package com.sanjayprajapat.mvvmarchitecture.ui.mediator

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MediatorViewModel4:ViewModel() {
    private val _liveDataOne = MutableLiveData<Int>(8)
    val liveDataOne: LiveData<Int> = _liveDataOne

    private val _liveDataTwo = MutableLiveData<Int>(90)
    val liveDataTwo: LiveData<Int> = _liveDataTwo

    private val _liveDataThree = MutableLiveData<Int>(56)
    val liveDataThree: LiveData<Int> = _liveDataThree

    val tripleMediatorLiveData = TripleMediatorLiveData(_liveDataOne, _liveDataTwo,_liveDataThree)


    fun changeLiveDataTwo(){
        viewModelScope.launch {
            delay(4)
            _liveDataTwo.value = 109
        }
    }


    /**
     * Transformation SwitchMAp to transform into one single live data dource
     * use the static Transformations.switchMap(..) function or
     * make use of the lifecycle-livedata-ktx function and use the switchMap function directly on the LiveData
     * implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
     * */

//    The switchMap function will be invoked as soon as any of the observed sources inside the TripleMediatorLiveData will update.
    val switchLiveData:LiveData<Int> = TripleMediatorLiveData(_liveDataOne,_liveDataTwo,_liveDataThree)
        .switchMap {
            mediatorState->
            val firstValue = mediatorState.first?.times(4)?:0
            val secondValue = mediatorState.second?.plus(90)?:0
            val thirdValue = mediatorState.third?.plus(89)?:0
            return@switchMap liveData {
                emit(firstValue*secondValue*thirdValue)
            }
        }

}