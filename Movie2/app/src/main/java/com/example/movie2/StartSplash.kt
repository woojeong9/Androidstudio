package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle

class StartSplash:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_splash)
        val handler=Handler()
        handler.postDelayed({
        val intent=Intent(baseContext,MainActivity::class.java)
        startActivity(intent)
        finish()},3000)
    }

}