package com.sanjayprajapat.mvvmarchitecture.ui.mediator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MediatorViewModel3:ViewModel() {
    private val _liveDataOne = MutableLiveData<String>("5")
    val liveDataOne: LiveData<String> = _liveDataOne

    private val _liveDataTwo = MutableLiveData<Int>(2)
    val liveDataTwo: LiveData<Int> = _liveDataTwo

    val pairMediatorLiveData = PairMediatorLiveData(_liveDataOne, _liveDataTwo)



}