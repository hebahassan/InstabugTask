package com.example.instabug.data.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "repeated_no") val repeatedNo: Int
)