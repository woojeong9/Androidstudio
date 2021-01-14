package com.example.android2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android2.databinding.ActivityMainBinding
import com.example.android2.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent1= Intent(this,MainActivity::class.java )
        startActivity(intent1)

    }
}