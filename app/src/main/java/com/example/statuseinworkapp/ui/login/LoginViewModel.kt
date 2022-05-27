package com.example.statuseinworkapp.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.statuseinworkapp.data.UserRepository
import com.example.statuseinworkapp.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

enum class ApiStatus {
    LOADING,
    SUCCESS,
    FAIL
}

class LoginViewModel(val userRepository: UserRepository):ViewModel() {

    lateinit var user : User
    val loginStatus = MutableLiveData<String>()

    fun getUser(id: String, password: Int){
        var result = ApiStatus.LOADING
        viewModelScope.launch {

            try {
                userRepository.getUser(id, password).let {
                    loginStatus.value =
                        if (it) "Login successful"
                        else "incorrect Password!"
                }

            }
            catch (e:Exception){
                loginStatus.value = "Something went wrong. Try again."
            }

//            user = userRepository.getUser(id)
//
//            if (user.password == password ){
//                Log.d("TAG", "getUser: success")
//                result = ApiStatus.SUCCESS
//
//            }else {
//                Log.d("TAG", "getUser: fail")
//                result = ApiStatus.FAIL
//            }
        }
//        return result
    }


}