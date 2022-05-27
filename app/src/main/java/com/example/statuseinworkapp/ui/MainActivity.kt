package com.example.statuseinworkapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.statuseinworkapp.R
import com.example.statuseinworkapp.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val vModel: RegisterViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}