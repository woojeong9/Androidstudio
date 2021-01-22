package com.example.search

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context,
                var list:List<roomentity01>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

}