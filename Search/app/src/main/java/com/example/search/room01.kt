package com.example.search

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.search.databinding.ActivityRoom01Binding
@SuppressLint("StaticFieldLeak")
class room01 : AppCompatActivity() {
    private lateinit var binding: ActivityRoom01Binding

    lateinit var db:roomdatabase01
    var memoList=listOf<roomentity01>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoom01Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = roomdatabase01.getInstance(this)!!
        binding.button.setOnClickListener{
            var memo=roomentity01(null, binding.editText.text.toString())
            insertdata(memo)
        }
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
    }

        fun insertdata(memo: roomentity01){
            val insertTask= object: AsyncTask<Unit, Unit, Unit>(){
                override fun doInBackground(vararg params: Unit?) {
                    db.Roomdao().insert(memo)
                }

                override fun onPostExecute(result: Unit?) {
                    super.onPostExecute(result)
                    getAlldata()
                }
            }
            insertTask.execute()
        }
        fun getAlldata(){
            val getTask=(object:AsyncTask<Unit,Unit,Unit>(){
                override fun doInBackground(vararg params: Unit?) {
                    memoList=db.Roomdao().getAll()
                }

                override fun onPostExecute(result: Unit?) {
                    super.onPostExecute(result)
                    setRecyclerView(memoList)
                }
            }).execute()

        }
        fun deletedata(){

        }
        fun setRecyclerView(memoList:List<roomentity01>){

        }
}