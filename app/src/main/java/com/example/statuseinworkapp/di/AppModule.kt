package com.example.statuseinworkapp.di

import com.example.statuseinworkapp.data.UserLocalDataSource
import com.example.statuseinworkapp.data.UserRemoteDataSource
import com.example.statuseinworkapp.data.UserRepository
import com.example.statuseinworkapp.data.network.BASE_URL
import com.example.statuseinworkapp.data.network.LoginService
import com.example.statuseinworkapp.data.network.client
import com.example.statuseinworkapp.ui.login.UserViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



val appModule = module {
    single {
        UserRepository(get(),get())
    }
    single {
        UserLocalDataSource()
    }
    single {
        UserRemoteDataSource(get())
    }
    single {
        val retrofit = get() as Retrofit
        val loginApiService = retrofit.create(LoginService::class.java)
        loginApiService
    }

    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        retrofit
    }
    viewModel{UserViewModel(get())}
}