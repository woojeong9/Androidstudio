package com.example.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.search.databinding.ActivitySp01Binding

class sp01 : AppCompatActivity() {
    private lateinit var binding: ActivitySp01Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySp01Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        loadData() //저장된 edit text의 값을 set text
    }

    private fun loadData() {
        val pref=getSharedPreferences("pref",0)
        binding.etHello.setText(pref.getString("name",""))
        //1번째 인자에는 저장한 키 값, 2번째는 키 값 데이터가 존재하지 않을 경우의 대체값
    }
    private fun saveData() {
        val pref=getSharedPreferences("pref",0) //이름과 모드 설정
        val edit=pref.edit() //수정모드
        edit.putString("name",binding.etHello.text.toString()) //1번째 인자는 키 값, 2번째 인자는 실제 담아둘 값.
        edit.apply() //값을 저장 완료
    }

    override fun onDestroy(){ //액티비티가 종료되었을 때 호출
        super.onDestroy()

        saveData() //edit text 값을 저장
    }



}