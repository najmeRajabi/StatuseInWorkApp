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
}