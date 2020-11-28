package com.example.instabug.data.mappers

import com.example.instabug.data.db.data.Word
import com.example.instabug.data.models.DataResponse
import com.example.instabug.domain.models.DisplayedDataModel

internal fun DataResponse.toDisplayedDataModel(): DisplayedDataModel {

    val data = HashMap<String, Int>()

    this.response.toStringList().forEach {
        var count = data[it] ?: 0
        data[it] = ++count
    }

    return DisplayedDataModel(data)
}

internal fun DisplayedDataModel.toWordsList(): List<Word> {

    return this.data.map {
        Word(content = it.key, repeatedNo = it.value)
    }
}

internal fun List<Word>.toDisplayedDataModel(): DisplayedDataModel {
    val dataMap = HashMap<String, Int>()

    this.forEach {
        dataMap += it.content to it.repeatedNo
    }

    return DisplayedDataModel(dataMap)
}

