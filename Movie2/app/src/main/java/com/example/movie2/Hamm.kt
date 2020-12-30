package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivityHammBinding

class Hamm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityHammBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hback.setOnClickListener {
            val intent= Intent(this@Hamm, MainActivity::class.java)
            startActivity(intent)
        }
    }
}