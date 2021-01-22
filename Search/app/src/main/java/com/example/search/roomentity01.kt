package com.example.search

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class roomentity01(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var memo: String=""
)