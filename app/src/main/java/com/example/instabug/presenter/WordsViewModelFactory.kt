package com.example.instabug.presenter

import com.example.instabug.di.Factory
import com.example.instabug.domain.usecase.IWordsUseCase

class WordsViewModelFactory(private val useCase: IWordsUseCase): Factory<WordsViewModel> {

    override fun create(): WordsViewModel {
        return WordsViewModel(useCase)
    }
}