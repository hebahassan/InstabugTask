package com.example.instabug.data.datasource

import com.example.instabug.data.apiservice.IApiService
import com.example.instabug.data.mappers.toDisplayedDataModel
import com.example.instabug.domain.datasource.IRemoteDataSource
import com.example.instabug.domain.models.DisplayedDataModel

internal class RemoteDataSourceImpl(private val apiService: IApiService): IRemoteDataSource {

    override fun fetchRemoteData(): DisplayedDataModel {
        return apiService.fetchHtmlResponse().toDisplayedDataModel()
    }
}