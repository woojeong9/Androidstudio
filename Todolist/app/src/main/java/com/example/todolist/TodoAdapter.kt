package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.databinding.ItemListBinding

class TodoAdapter (
    private val dataset:ArrayList<ToDoList>,
    val ClickDelete:(todo: ToDoList)->Unit,
    val ClickItem:(todo: ToDoList)->Unit): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
    {
        inner class TodoViewHolder(val binding: ItemListBinding):
                RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
            val view=LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_list,parent,false)
            return TodoViewHolder(ItemListBinding.bind(view))
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            val todo: ToDoList=dataset[position]
            holder.binding.todoText.text=todo.text

            if(todo.done){
                holder.binding.check.setImageResource(R.drawable.check)
            }
            else{
                holder.binding.check.setImageResource(0)
            }

            holder.binding.delete.setOnClickListener{
                ClickDelete.invoke(todo)
            }
            holder.binding.root.setOnClickListener{
                ClickItem.invoke(todo)
            }
            val layoutParams=holder.itemView.layoutParams
            layoutParams.height=200
            holder.itemView.requestLayout()
        }

        override fun getItemCount(): Int {
            return dataset.size
        }

    }
