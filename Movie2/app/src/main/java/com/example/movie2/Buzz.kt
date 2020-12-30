package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivityBuzzBinding


class Buzz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityBuzzBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bback.setOnClickListener{
            val intent=Intent(this@Buzz, MainActivity::class.java)
            startActivity(intent)
        }
    }
}