package com.example.statuseinworkapp.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.statuseinworkapp.data.UserRepository
import com.example.statuseinworkapp.model.User
import kotlinx.coroutines.launch

class RegisterViewModel(val userRepository: UserRepository): ViewModel() {

     val user= MutableLiveData<User>()

    fun register(name:String , password:Int){
        viewModelScope.launch {
            userRepository.register(User(name = name , password = password))
            user.value = userRepository.mUser
        }
    }


}