package com.example.instabug.data.datasource

import com.example.instabug.data.apiservice.ApiService
import com.example.instabug.data.mappers.toDisplayedDataModel
import com.example.instabug.domain.datasource.IRemoteDataSource
import com.example.instabug.domain.models.DisplayedDataModel

internal class RemoteDataSourceImpl(private val apiService: ApiService): IRemoteDataSource {

    override fun fetchRemoteData(): DisplayedDataModel {
        return apiService.fetchHtmlResponse().toDisplayedDataModel()
    }
}