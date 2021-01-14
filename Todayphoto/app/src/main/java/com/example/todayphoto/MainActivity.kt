package com.example.todayphoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Todayphoto)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}