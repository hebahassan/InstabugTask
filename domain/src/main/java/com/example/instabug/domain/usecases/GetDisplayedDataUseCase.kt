package com.example.instabug.domain.usecases

import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRemoteRepo

class GetDisplayedDataUseCase(private val remoteRepo: IRemoteRepo) {

    fun execute(): DisplayedDataModel {
        return remoteRepo.fetchData()
    }
}