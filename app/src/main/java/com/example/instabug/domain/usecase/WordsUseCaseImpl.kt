package com.example.instabug.domain.usecase

import com.example.instabug.domain.repo.IRepository

class WordsUseCaseImpl(private val repository: IRepository): IWordsUseCase {

    override fun convertResponse(): List<String> {
        val regex = "[^A-Za-z ]".toRegex()

        val response = repository.fetchHtmlResponse()
        val convertedResponse = regex.replace(response, " ")

        return convertedResponse.split(" ").filter { it != "" }
    }

    override fun mappingData(responseList: List<String>): Map<String, Int> {
        val wordsMap = HashMap<String, Int>()

        responseList.forEach {
            var count = wordsMap[it] ?: 0
            wordsMap[it] = ++count
        }

        return wordsMap
    }
}