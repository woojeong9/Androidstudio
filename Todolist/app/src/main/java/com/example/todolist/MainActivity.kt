package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val data=ArrayList<ToDoList>()
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.recyclerView.apply{
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=TodoAdapter(data,ClickDelete = {deleteTodo(it)},ClickItem = {toggleTodo(it)})

        }
        binding.add.setOnClickListener{
            addTodo()
        }

    }
    private fun toggleTodo(todo: ToDoList){
        todo.done=!todo.done
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
    private fun addTodo(){
        val todo=ToDoList(binding.editText.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
    private fun deleteTodo(todo: ToDoList){
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}