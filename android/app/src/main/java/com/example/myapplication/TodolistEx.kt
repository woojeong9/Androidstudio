package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityTodolistExBinding
import com.example.myapplication.databinding.TodolistexBinding

class TodolistEx : AppCompatActivity() {
    private val data=ArrayList<TodolistEx>()
    private lateinit var binding: ActivityTodolistExBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTodolistExBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.recyclerView.apply{
            layoutManager=LinearLayoutManager(this@TodolistEx)

        }
    }
}
class TodoAdapter(
    private val myDataset: ArrayList<TodolistEx>,
    val onClickDeleteIcon: (todo: TodolistEx) ->Unit,
    val onClickItem: (todo: TodolistEx )->Unit):
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    inner class TodoViewHolder(val binding: TodolistexBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.todolistex,parent,false)
        return TodoViewHolder(TodolistexBinding.bind(view))
    }

}

