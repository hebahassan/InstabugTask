package com.example.instabug.presenter

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instabug.domain.usecase.IWordsUseCase
import com.example.instabug.util.ErrorState
import com.example.instabug.util.LoadingState
import com.example.instabug.util.SuccessState
import com.example.instabug.util.ViewModelState
import java.io.IOException
import java.util.concurrent.Executors

class WordsViewModel(private val useCase: IWordsUseCase): ViewModel() {

    val receivedData = MutableLiveData<ViewModelState>()

    init {
        fetchMappedResponse()
    }

    private fun fetchMappedResponse() {
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        receivedData.value = LoadingState

        executor.execute {
            try {
                val list = useCase.convertResponse()
                val response = useCase.mappingResponse(list)

                handler.post {
                    receivedData.value = SuccessState(response)
                }
            }catch (e: IOException) {
                handler.post {
                    receivedData.value = ErrorState(e)
                }
            }
        }

    }
}