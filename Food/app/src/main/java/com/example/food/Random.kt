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


        val random=Random()
        fun rand(): String{
            val arr= mutableListOf<String>(
                    "떡볶이","돈가스","피자","김밥","라면","치킨","짜장면","짬뽕","샤브샤브","칼국수",
                    "우동","월남쌈","토스트","유부초밥","볶음밥","샐러드","오므라이스","팬케이크","삼겹살"
            )
            return random.toString()
        }


        binding.Start.setOnClickListener(){
            val intent= Intent(this@Random, RandomChoice::class.java )
            println(rand())
        }

    }
}