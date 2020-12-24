package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent1.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        var acb=10
        var b=acb*10
        var c=acb*100
            change_activity.setOnClickListener{
            val intent=Intent(this@Intent1,Intent2::class.java)
            intent.putExtra("number1",1)
            intent.putExtra("number2",2)
            startActivity(intent)
        }
    }
}