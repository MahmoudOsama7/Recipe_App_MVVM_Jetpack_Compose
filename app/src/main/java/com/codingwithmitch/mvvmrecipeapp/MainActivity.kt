package com.codingwithmitch.mvvmrecipeapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.mvvmrecipeapp.R
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}






















