package com.example.statuseinworkapp.data

import com.example.statuseinworkapp.data.network.LoginService
import com.example.statuseinworkapp.model.User

class UserRemoteDataSource(var loginApiService: LoginService) {

    suspend fun register(user: User): User{
        return loginApiService.register(user)
    }

    suspend fun getUser(id:String): User{
        return loginApiService.getUser(id)
    }

}