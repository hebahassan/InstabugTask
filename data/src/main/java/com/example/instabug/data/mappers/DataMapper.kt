package com.example.instabug.data.mappers

import com.example.instabug.data.models.DataResponse
import com.example.instabug.domain.models.DisplayedDataModel

internal class DataMapper {

    fun toDisplayedDataModel(dataResponse: DataResponse): DisplayedDataModel {
        val data = HashMap<String, Int>()

         dataResponse.response.toStringList().filter { it != "" }.forEach {
            var count = data[it] ?: 0
             data[it] = ++count
         }

        return DisplayedDataModel(data)
    }
}