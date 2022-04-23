package com.sanjayprajapat.mvvmarchitecture.ui.mediator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData


/**
 *  combination of LiveData sources that get automatically combined into one single LiveData source
 *  can be use other  class type as data holder.
 * */
class PairMediatorLiveData<F, S>(firstLiveData: LiveData<F>, secondLiveData: LiveData<S>)
    : MediatorLiveData<Pair<F?, S?>>() {
    init {
        addSource(firstLiveData) { firstLiveDataValue: F ->  value =
            firstLiveDataValue to secondLiveData.value }
        addSource(secondLiveData) { secondLiveDataValue: S -> value =
            firstLiveData.value to secondLiveDataValue }
    }
}
