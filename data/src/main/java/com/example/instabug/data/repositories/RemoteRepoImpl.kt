package com.example.instabug.data.repositories

import com.example.instabug.data.apiservice.IApiService
import com.example.instabug.data.mappers.DataMapper
import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRemoteRepo

internal class RemoteRepoImpl(private val apiService: IApiService,
                     private val dataMapper: DataMapper): IRemoteRepo {

    override fun fetchData(): DisplayedDataModel {

        return dataMapper.toDisplayedDataModel(apiService.fetchHtmlResponse())
    }
}