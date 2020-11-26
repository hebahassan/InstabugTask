package com.example.instabug.domain.usecase

interface IWordsUseCase {

    fun convertResponse(): List<String>

    fun mappingResponse(list: List<String>): HashMap<String, Int>
}