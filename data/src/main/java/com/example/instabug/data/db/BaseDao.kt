package com.example.instabug.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

interface BaseDao<T> {

    fun selectAll(): List<T>

    @Insert(onConflict = IGNORE)
    fun insert(t: T): Long

    @Insert(onConflict = REPLACE)
    fun insert(ts: List<T>)

    @Update(onConflict = REPLACE)
    fun update(t: T)

    @Update(onConflict = REPLACE)
    fun update(ts: List<T>)

    @Delete
    fun delete(t: T): Int

    fun deleteAll()
}