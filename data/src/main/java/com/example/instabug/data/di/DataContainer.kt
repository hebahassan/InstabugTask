package com.example.instabug.data.di

import android.content.Context
import androidx.room.Room
import com.example.instabug.common.network.INetworkProvider
import com.example.instabug.common.network.NetworkProvider
import com.example.instabug.data.apiservice.ApiService
import com.example.instabug.data.apiservice.IApiService
import com.example.instabug.data.datasource.LocalDataSourceImpl
import com.example.instabug.data.datasource.RemoteDataSourceImpl
import com.example.instabug.data.db.MyDatabase
import com.example.instabug.data.repositories.RepositoryImpl
import com.example.instabug.domain.datasource.ILocalDataSource
import com.example.instabug.domain.datasource.IRemoteDataSource
import com.example.instabug.domain.repositories.IRepository

class DataContainer(context: Context) {

    private val networkProvider: INetworkProvider = NetworkProvider(context)

    private val apiService: IApiService = ApiService("https://instabug.com")
    private val database = Room.databaseBuilder(context, MyDatabase::class.java, "MyDatabase").build()

    private val localDataSource: ILocalDataSource = LocalDataSourceImpl(database.wordsDao())
    private val remoteDataSource: IRemoteDataSource = RemoteDataSourceImpl(apiService)

    val repository: IRepository = RepositoryImpl(remoteDataSource, localDataSource, networkProvider)
}