package com.example.instabug.data.repositories

import com.example.instabug.domain.datasource.ILocalDataSource
import com.example.instabug.domain.datasource.IRemoteDataSource
import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRepository

internal class RepositoryImpl(remoteDataSource: IRemoteDataSource,
                              localDataSource: ILocalDataSource) : IRepository {

    override fun fetchData(): DisplayedDataModel {
        //TODO: determine whether to fetch data from server or database
    }
}