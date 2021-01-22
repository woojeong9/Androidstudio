package com.example.search

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class Memo(var no:Long?, var content:String, var datetime:Long)
class Sqlitehelper(context: Context, name:String, version: Int)
    : SQLiteOpenHelper(context, name, null, version ){
    override fun onCreate(db: SQLiteDatabase?) {
        //이름이 없을 때
        //파일과 테이블 생성
        val create= "create table memo (`no` integer primary key, content text, datetime integer)"
                    //명령어     //이름 //컬럼명 /타입 /자동으로 컬럼 지정됨
        db?.execSQL(create)
        }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //이름은 있는데 버전이 다를 때
        //테이블에 변경사항이 있을 경우 호출됨
    }

    //데이터 입력 함수
    fun insertMemo(memo: Memo){
        val wd= writableDatabase
        //db를 가져옴
        val values= ContentValues()
        //Memo를 입력타입으로 변환
        values.put("content",memo.content)
        values.put("datatime",memo.datetime)
        //         컬럼명      값
        wd.insert("memo", null, values)
            // 테이블 이름                    값
        //db에 넣음
        wd.close()
        //db 닫음
    }
    //데이터 조회함수
    fun selectMemo():MutableList<Memo>{
        val list= mutableListOf<Memo>()
        val select= "select * from memo"
        //memo 테이블에서 모든 컬럼을 선택
        val rd=readableDatabase
        val cursor= rd.rawQuery(select,null)
        //cursor를 반환하는데 cursor는 일종의 리스트로 반복문을 돌면서 반환한다
        while(cursor.moveToNext()){
            //첫번째 줄의 데이터를 꺼내게 함
            val no=cursor.getLong(cursor.getColumnIndex("no"))
            //몇 번째인지 알려줘야 함
            val content=cursor.getString(cursor.getColumnIndex("content"))
            val datetime= cursor.getLong(cursor.getColumnIndex("datatime"))

            val memo=Memo(no,content,datetime)
            list.add(memo)
            //리스트에 담아줌
        }
        cursor.close()
        rd.close()
        return list
    }
}

