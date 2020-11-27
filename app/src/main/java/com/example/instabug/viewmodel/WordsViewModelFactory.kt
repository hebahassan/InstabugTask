package com.example.instabug.viewmodel

import com.example.instabug.di.Factory
import com.example.instabug.domain.usecases.GetDisplayedDataUseCase
import com.example.instabug.ui.datascreen.DataViewModel

class WordsViewModelFactory(private val useCase: GetDisplayedDataUseCase): Factory<DataViewModel> {

    override fun create(): DataViewModel {
        return DataViewModel(useCase)
    }
}