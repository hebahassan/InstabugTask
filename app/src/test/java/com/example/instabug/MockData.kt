package com.example.instabug

import com.example.instabug.domain.models.DisplayedDataModel

object MockData {
    private val responseMap = hashMapOf("html" to 2, "head" to 2, "Title" to 1)
    val displayedDataModel = DisplayedDataModel(responseMap)
}