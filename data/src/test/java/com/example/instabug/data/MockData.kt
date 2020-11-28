package com.example.instabug.data

import com.example.instabug.data.db.data.Word
import com.example.instabug.data.models.DataResponse
import com.example.instabug.domain.models.DisplayedDataModel

internal object MockData {
    val htmlResponse = "<html><head>Title</head></html>"
    val dataResponse = DataResponse(response = " html  head Title  head   html ")
    val responseList = listOf("html", "head", "Title", "head", "html")
    val responseMap = hashMapOf("html" to 2, "head" to 2, "Title" to 1)
    val displayedDataModel = DisplayedDataModel(responseMap)

    val wordsList = listOf(
        Word(null, "head", 2),
        Word(null, "Title", 1),
        Word(null, "html", 2))
    val wordsMap = hashMapOf("head" to 2, "Title" to 1, "html" to 2)
    val wordsDataModel = DisplayedDataModel(wordsMap)
}