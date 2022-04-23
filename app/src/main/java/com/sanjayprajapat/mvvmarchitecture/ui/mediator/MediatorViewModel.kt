package com.sanjayprajapat.mvvmarchitecture.ui.mediator

import androidx.lifecycle.*
import com.sanjayprajapat.mvvmarchitecture.data.User


class MediatorViewModel:ViewModel() {

    // ex. the LiveData from Room won't be exposed to the view...
    val usersList:LiveData<List<User>> = MutableLiveData(getUserNewList())
    // ...because this is what we'll want to expose
    val usersMed = MediatorLiveData<List<User>>()

    companion object{
        private var ASCENDING = 1
        private var DESCENDING = 2
    }
    init {
        // here our MediatorLiveData is basically a proxy to dbusers
        usersMed.addSource(usersList){
          it?.let {
              // set value in mediator live data
              usersMed.value = sortBooks(it, DESCENDING)
          }
        }
    }


    fun sortBooks(users:List<User>,order:Int):List<User>{
        return users.sortedByDescending { it.age }
    }


    fun getUserNewList():List<User>{
        val users:ArrayList<User> = ArrayList<User>()
        users.add(User(name = "Justin Bieber", 21))
        users.add(User(name = "Taylor ", 23))
        users.add(User(name = "Robins", 20))
        users.add(User(name = "Ken", 28))
        users.add(User(name = "Chris", 21))
        users.add(User(name = "Bruce", 36))
        users.add(User(name = "James", 30))
        users.add(User(name = "Cam", 29))
        return users
    }

}