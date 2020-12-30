package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivityJessieBinding

class Jessie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityJessieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.jback.setOnClickListener{
            val intent= Intent(this@Jessie, MainActivity::class.java)
            startActivity(intent)
        }
    }
}