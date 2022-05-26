package com.example.statuseinworkapp.data.network

import com.example.statuseinworkapp.model.User
import com.example.statuseinworkapp.ui.login.UserViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Body
import retrofit2.http.POST


val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()
const val BASE_URL = "https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/"

interface LoginService {

    @POST("users")
    suspend fun register(@Body user: User): User
}