package com.example.instabug.viewmodel

import com.example.instabug.domain.models.DisplayedDataModel

sealed class ViewModelState

object LoadingState: ViewModelState()

data class SuccessState(val data: DisplayedDataModel): ViewModelState()

data class ErrorState(val throwable: Throwable): ViewModelState()