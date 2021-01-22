package com.example.search

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities= arrayOf(roomentity01::class), version=1)
abstract  class roomdatabase01:RoomDatabase() {
    abstract fun Roomdao():roomdao

    companion object{
        var INSTANCE: roomdatabase01?= null

        fun getInstance(context: Context):roomdatabase01?{
            if(INSTANCE==null){
                synchronized(roomdatabase01::class){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,
                    roomdatabase01::class.java,"memo.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}