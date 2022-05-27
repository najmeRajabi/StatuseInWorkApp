package com.example.statuseinworkapp.data.network

import com.example.statuseinworkapp.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()
const val BASE_URL = "https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/"

interface LoginService {

    @POST("users")
    suspend fun register(@Body user: User): User

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id : String): User
}