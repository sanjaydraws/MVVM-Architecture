package com.sanjayprajapat.mvvmarchitecture.ui.mediator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class TripleMediatorLiveData <F, S, T>(firstLiveData:LiveData<F>, secondLiveData:LiveData<S>, thirdLiveData:LiveData<T>)
    :MediatorLiveData<Triple<F?,S?,T?>>(){
    init {
        addSource(firstLiveData){
                firstLiveDataValue:F ->
            value = Triple(first = firstLiveDataValue,
                second = secondLiveData.value,third = thirdLiveData.value)
        }
        addSource(secondLiveData){
            secondLiveDataValue:S ->
            Triple(firstLiveData.value, secondLiveDataValue,thirdLiveData.value )
        }
        addSource(thirdLiveData){
            thirdLiveDataValue:T ->
            Triple(firstLiveData.value, secondLiveData.value, thirdLiveDataValue)
        }

    }

}