package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val checklist= arrayListOf(
                CheckList(R.mipmap.ic_launcher, "우정"),
                CheckList(R.mipmap.ic_launcher,"수현"),
                CheckList(R.mipmap.ic_launcher,"지우"),
                CheckList(R.mipmap.ic_launcher,"아연"),
                CheckList(R.mipmap.ic_launcher,"미애")
        )
        rv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.setHasFixedSize(true)
        rv.adapter=CheckListAdapter(checklist)
    }
}