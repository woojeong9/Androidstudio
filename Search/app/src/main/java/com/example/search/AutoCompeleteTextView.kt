package com.example.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil.*
import com.example.search.databinding.ActivityAutoCompeleteTextViewBinding
import com.example.search.databinding.AutocompeleteDataBinding

class AutoCompeleteTextView : AppCompatActivity() {

    private lateinit var binding: AutocompeleteDataBinding

    var wordList= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= AutocompeleteDataBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.searchBar.autoTv.threshold=1

        binding.enrollBtn.setOnClickListener{
            wordList.add(binding.enrollInput.text.toString())
            val adapter= ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line,wordList)
            //문자열을 보여주는 리스트 역할
            binding.searchBar.autoTv.setAdapter(adapter)

            binding.enrollInput.setText("")
        }
        binding.searchBar.searchImage.setOnClickListener{
            binding.result.text="선택된 단어는 ${binding.searchBar.autoTv.text}이며, " +
                    "\n${binding.searchBar.autoTv.text.length}글자로 이루어져 있습니다."
            binding.searchBar.autoTv.setText("")

        }

        binding.searchBar.autoTv.setOnItemClickListener{
            parent, view, position, id -> binding.result.text ="선택된 단어는 ${binding.searchBar.autoTv.text}이며, " +
                    "\n${binding.searchBar.autoTv.text.length}글자로 이루어져 있습니다."
            binding.searchBar.autoTv.setText("")
        }

    }
}