package com.example.instabug.domain.usecases

import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRepository

class GetDisplayedDataUseCase(private val repository: IRepository) {

    fun execute(): DisplayedDataModel {
        return repository.fetchData()
    }
}