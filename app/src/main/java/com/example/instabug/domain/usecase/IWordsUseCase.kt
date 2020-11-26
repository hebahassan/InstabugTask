package com.example.instabug.domain.usecase

interface IWordsUseCase {

    fun convertResponse(): List<String>

    fun mappingData(responseList: List<String>): Map<String, Int>
}