package com.example.instabug.domain.datasource

import com.example.instabug.domain.models.DisplayedDataModel

interface ILocalDataSource {

    fun replaceWordsData(data: DisplayedDataModel)

    fun selectAllData(): DisplayedDataModel

    fun deleteAllData()
}