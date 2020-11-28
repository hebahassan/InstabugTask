package com.example.instabug.data.repositories

import com.example.instabug.common.network.INetworkProvider
import com.example.instabug.domain.datasource.ILocalDataSource
import com.example.instabug.domain.datasource.IRemoteDataSource
import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRepository

internal class RepositoryImpl(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource,
    private val networkProvider: INetworkProvider
) : IRepository {

    override fun fetchData(): DisplayedDataModel {
        var data: DisplayedDataModel? = null

        when (networkProvider.isConnected()) {
            true -> {
                data = remoteDataSource.fetchRemoteData()
                localDataSource.replaceWordsData(data)
            }

            false -> {
                data = localDataSource.displayWordsData()
            }
        }

        return data
    }
}