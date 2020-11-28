package com.example.instabug.domain.datasource

import com.example.instabug.domain.models.DisplayedDataModel

interface IRemoteDataSource {

    fun fetchRemoteData(): DisplayedDataModel
}