package com.example.instabug.data.di

import android.content.Context
import androidx.room.Room
import com.example.instabug.data.apiservice.ApiService
import com.example.instabug.data.db.MyDatabase
import com.example.instabug.data.repositories.RepositoryImpl
import com.example.instabug.domain.repositories.IRepository

class DataContainer(context: Context) {

    private val apiService = ApiService("https://instabug.com")
//    val repository: IRepository = RepositoryImpl(apiService)

    private val database = Room.databaseBuilder(context, MyDatabase::class.java, "MyDatabase").build()
}