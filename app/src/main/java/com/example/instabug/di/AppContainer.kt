package com.example.instabug.di

import com.example.instabug.data.remote.ApiSourceImpl
import com.example.instabug.data.remote.IApiSource
import com.example.instabug.domain.repo.IRepository
import com.example.instabug.domain.repo.RepositoryImpl
import com.example.instabug.domain.usecase.IWordsUseCase
import com.example.instabug.domain.usecase.WordsUseCaseImpl
import com.example.instabug.presenter.WordsViewModelFactory

class AppContainer {

    private val apiSource: IApiSource = ApiSourceImpl("https://instabug.com")
    private val repository: IRepository = RepositoryImpl(apiSource)
    private val wordsUseCase: IWordsUseCase = WordsUseCaseImpl(repository)

    val wordsViewModelFactory = WordsViewModelFactory(wordsUseCase)
}