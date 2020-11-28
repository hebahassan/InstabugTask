package com.example.instabug.data.db.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.instabug.data.db.BaseDao

@Dao
interface WordsDao: BaseDao<Word> {

    @Transaction
    fun replace(words: List<Word>) {
        deleteAll()
        insert(words)
    }

    @Query("SELECT * FROM word_table")
    override fun selectAll(): List<Word>

    @Query("DELETE FROM word_table")
    override fun deleteAll()
}