package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivitySlinkyBinding

class Slinky : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivitySlinkyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sback.setOnClickListener {
            val intent= Intent(this@Slinky,MainActivity::class.java)
            startActivity(intent)
        }
    }
}