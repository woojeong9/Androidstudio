package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivityAlienBinding

class Alien : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityAlienBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aback.setOnClickListener {
            val intent= Intent(this@Alien,MainActivity::class.java)
            startActivity(intent)
        }
    }
}