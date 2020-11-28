package com.example.instabug.di

import com.example.instabug.data.di.DataContainer
import com.example.instabug.domain.usecases.GetDisplayedDataUseCase
import com.example.instabug.viewmodel.WordsViewModelFactory

class DisplayDataContainer(dataContainer: DataContainer) {

    private val useCase = GetDisplayedDataUseCase(dataContainer.repository)

    val viewModelFactory = WordsViewModelFactory(useCase)
}