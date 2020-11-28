package com.example.instabug.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.instabug.data.db.data.Word
import com.example.instabug.data.db.data.WordsDao

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class MyDatabase: RoomDatabase() {

    abstract fun wordsDao(): WordsDao
}