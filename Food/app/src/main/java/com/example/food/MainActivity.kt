package com.example.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.randomBtn.setOnClickListener{
            val intent=Intent(this@MainActivity,Random::class.java)
        }
        binding.conanBtn.setOnClickListener{
            val intent=Intent(this@MainActivity,Conan::class.java)
        }


    }
}