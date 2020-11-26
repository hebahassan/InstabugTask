package com.example.instabug.util

sealed class ViewModelState

object LoadingState: ViewModelState()

data class SuccessState(val data: HashMap<String, Int>): ViewModelState()

data class ErrorState(val throwable: Throwable): ViewModelState()