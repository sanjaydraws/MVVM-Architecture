package com.sanjayprajapat.mvvmarchitecture.ui.mediator

import androidx.lifecycle.*


/**
 * Merging Two Live Data Sources
 * */
class MediatorViewModel2:ViewModel() {
    private val _liveDataOne = MutableLiveData<Int>()
    val liveDataOne:LiveData<Int> = MutableLiveData<Int>(2)

    private val _liveDataTwo = MutableLiveData<Int>()
    val liveDataTwo:LiveData<Int> = MutableLiveData<Int>()

    val mediatorLiveData = MediatorLiveData<Int>()


    init {
        mediatorLiveData.addSource(_liveDataOne,
            object : Observer<Int> {
            var invocationCount: Int = 0

            override fun onChanged(updatedValue: Int) {
                ++invocationCount

                mediatorLiveData.value = updatedValue + 10

                if (invocationCount > 10) {
                    mediatorLiveData.removeSource(_liveDataOne)
                }
            }
        })
        //return value will be new value of mediator live data
        mediatorLiveData.addSource(_liveDataTwo){
            updatedValue -> updatedValue + 10
            mediatorLiveData.value = updatedValue
        }
    }


}