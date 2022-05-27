package com.example.statuseinworkapp.data

import com.example.statuseinworkapp.model.User


class UserRepository(
    val userRemoteDataSource: UserRemoteDataSource,
    val userLocalDataSource: UserLocalDataSource) {

    var mUser:User? = null

    suspend fun register(user: User): User? {
        mUser=userRemoteDataSource.register(user)
        return mUser
    }

    suspend fun getUser(id: String): User{
        return userRemoteDataSource.getUser(id)
    }

    suspend fun getUser(id: String, password: Int): Boolean {
        var loginSuccessful: Boolean = false
        userRemoteDataSource.getUser(id).let {
            if (it.password == password) {
                mUser = it
                loginSuccessful = true
            }
        }
        return loginSuccessful
    }
}