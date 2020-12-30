package com.example.movie2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.woody.setOnClickListener{
            val intent=Intent(this@MainActivity,Woody::class.java)
            startActivity(intent)
        }
        binding.buzz.setOnClickListener{
            val intent=Intent(this@MainActivity,Buzz::class.java)
            startActivity(intent)
        }
        binding.jessie.setOnClickListener{
            val intent=Intent(this@MainActivity,Jessie::class.java)
            startActivity(intent)
        }
        binding.alien.setOnClickListener {
            val intent=Intent(this@MainActivity,Alien::class.java)
            startActivity(intent)
        }
        binding.slinky.setOnClickListener {
            val intent=Intent(this@MainActivity, Slinky::class.java)
            startActivity(intent)
        }
        binding.forky.setOnClickListener {
            val intent=Intent(this@MainActivity,Forky::class.java)
            startActivity(intent)
        }
        binding.hamm.setOnClickListener {
            val intent=Intent(this@MainActivity,Hamm::class.java)
            startActivity(intent)
        }
    }
}