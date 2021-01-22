package com.example.idmemolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idmemolist.databinding.ActivityDataListBinding

class DataList : AppCompatActivity() {
    private lateinit var binding: ActivityDataListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDataListBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.etcButton.setOnClickListener{
            val intent= Intent(this@DataList,DataListEdit::class.java)
            startActivity(intent)
        }


    }
}