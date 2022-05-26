package com.example.statuseinworkapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.statuseinworkapp.R
import com.example.statuseinworkapp.ui.login.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val vModel: UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}