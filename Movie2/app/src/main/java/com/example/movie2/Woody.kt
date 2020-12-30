package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivityWoodyBinding

class Woody : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityWoodyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.wback.setOnClickListener{
            val intent=Intent(this@Woody, MainActivity::class.java)
            startActivity(intent)
        }
    }
}