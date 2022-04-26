package com.sanjayprajapat.mvvmarchitecture.ui.livedata_

import androidx.lifecycle.*
import com.sanjayprajapat.mvvmarchitecture.data.User

//  All of the Transformations class functions  are also  available as
//  extension functions on LiveData using the dependency:
//    androidx.lifecycle:lifecycle-livedata-ktx:<version>

class LiveDataTransformationViewModel:ViewModel() {
    // get value from database
    val _userList = MutableLiveData(getUserNewList())
    val usersList: LiveData<List<User>> = _userList

    /**
     * get all users name
     * */
    val usersNames:LiveData<List<String>> =  Transformations.map(usersList){
        user -> user.map {
            it.name
        }
    }
    /**
     * Every time the search text changes we want to update search results
     * */
    val searchQuery:LiveData<String> = MutableLiveData("Justin")
    fun getSearchResult(query:String) :LiveData<List<User>> = MutableLiveData(getUserNewList())

    val searchResult:LiveData<List<User>> =
        Transformations.switchMap(searchQuery){
            getSearchResult(it)
        }



    /**
     * Transform user name
     * */
    val user:LiveData<User> = MutableLiveData(User(name = "Justin Bieber", age = 23))
    val userName:LiveData<String> = Transformations.map(user){
        it.name + "Purpose "
    }

    //distinctUntilChanged example
    /**
     * Filters LiveDataso that values will not be emitted unless they have changed.
     * */
    val userNames2:LiveData<List<String>> =
        Transformations.distinctUntilChanged(
            Transformations.map(usersList){
                users -> users.map { it.name.uppercase() }
            }
        )

    // also can be use extension function same as transformation function
    val userNames3: LiveData<List<String>> =
        usersList.map { it.map { player -> player.name } }
            .distinctUntilChanged()


    fun changeUserList(){
        _userList.postValue(getNewList())
    }


    fun getNewList():List<User>{
        val users:ArrayList<User> = ArrayList<User>()
        users.add(User(name = "Spider Man", 21))
        users.add(User(name = "Iron MAn", 23))
        users.add(User(name = "Super MAn", 20))
        users.add(User(name = "XYZ", 28))
        return users
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