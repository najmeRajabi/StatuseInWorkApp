package com.example.statuseinworkapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.statuseinworkapp.data.UserRepository
import com.example.statuseinworkapp.model.User
import kotlinx.coroutines.launch

class UserViewModel(val userRepository: UserRepository): ViewModel() {

     val user= MutableLiveData<User>()

    fun register(name:String , password:String){
        viewModelScope.launch {
            userRepository.register(User(name = name , password = password))
            user.value = userRepository.mUser
        }
    }
}