package com.example.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CheckListAdapter (val checklist: ArrayList<CheckList>) :
    RecyclerView.Adapter<CheckListAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CheckListAdapter.CustomViewHolder {
            val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
            return CustomViewHolder(view).apply{
                itemView.setOnClickListener{
                    val curpos: Int=adapterPosition
                    val check: CheckList=checklist.get(curpos)
                    Toast.makeText(parent.context,"${check.thing}",Toast.LENGTH_SHORT)
                }
            }
    }

    override fun getItemCount(): Int {
        return checklist.size
    }

    override fun onBindViewHolder(holder: CheckListAdapter.CustomViewHolder, position: Int) {
        holder.checkbox.setImageResource(checklist.get(position).box)
        holder.checktext.text=checklist.get(position).thing
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val checkbox=itemView.findViewById<ImageView>(R.id.checkbox)
        val checktext=itemView.findViewById<TextView>(R.id.text)
    }

}