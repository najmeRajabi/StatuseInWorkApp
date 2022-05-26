package com.example.statuseinworkapp.model

import com.squareup.moshi.Json

data class User(

    @Json(name = "id")
    val id : String = "0" ,

    @Json(name = "name")
    val name: String ,

    @Json(name = "avatar")
    val avatar: String? = null ,

    @Json(name = "status")
    val status: String = "new" ,

    @Json(name = "password")
    val password : String
)
