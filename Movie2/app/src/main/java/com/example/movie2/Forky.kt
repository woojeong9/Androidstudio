package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivityForkyBinding

class Forky : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityForkyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fback.setOnClickListener {
            val intent = Intent(this@Forky, MainActivity::class.java)
            startActivity(intent)
        }
    }
}