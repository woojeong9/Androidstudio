package com.example.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class sqlite01 : AppCompatActivity() {

    val DB_NAME="sqlite.sql"
    val DB_VERSION=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite01)

        val helper=Sqlitehelper(this,DB_NAME,DB_VERSION)

    }
}