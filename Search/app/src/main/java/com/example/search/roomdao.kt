package com.example.search

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface roomdao {
    @Insert(onConflict=REPLACE)
    //primarykey가 동일할 경우 덮어씌우겠다
    fun insert(memo: roomentity01)

    @Query("SELECT * FROM memo")
    fun getAll(): List<roomentity01>

    @Delete
    fun delete(memo: roomentity01)
}