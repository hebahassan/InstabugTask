package com.example.instabug.data.di

import com.example.instabug.data.apiservice.ApiServiceImpl
import com.example.instabug.data.apiservice.IApiService
import com.example.instabug.data.mappers.DataMapper
import com.example.instabug.data.repositories.RemoteRepoImpl
import com.example.instabug.domain.repositories.IRemoteRepo

class DataContainer {

    private val apiService: IApiService = ApiServiceImpl("https://instabug.com")
    val remoteRepo: IRemoteRepo = RemoteRepoImpl(apiService, DataMapper())
}