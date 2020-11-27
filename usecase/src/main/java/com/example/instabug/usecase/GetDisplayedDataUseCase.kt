package com.example.instabug.usecase

import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRemoteRepo
import com.example.instabug.domain.usecases.IUseCase

class GetDisplayedDataUseCase(private val remoteRepo: IRemoteRepo):
    IUseCase<DisplayedDataModel> {

    override fun execute(): DisplayedDataModel {
        return remoteRepo.fetchData()
    }
}