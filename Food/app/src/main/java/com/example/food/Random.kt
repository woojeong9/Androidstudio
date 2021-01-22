package com.example.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food.databinding.ActivityRandomBinding
import java.util.Random

class Random : AppCompatActivity() {
    private lateinit var binding: ActivityRandomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRandomBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)



        binding.startbutton.setOnClickListener(){
            val intent= Intent(this@Random, RandomChoice::class.java )
            startActivity(intent)
        }

    }
}