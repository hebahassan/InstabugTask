package com.example.instabug.ui.datascreen

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instabug.domain.usecases.GetDisplayedDataUseCase
import com.example.instabug.viewmodel.ErrorState
import com.example.instabug.viewmodel.LoadingState
import com.example.instabug.viewmodel.SuccessState
import com.example.instabug.viewmodel.ViewModelState
import java.io.IOException
import java.util.concurrent.Executors

class DataViewModel(private val useCase: GetDisplayedDataUseCase): ViewModel() {

    val receivedData = MutableLiveData<ViewModelState>()

    fun fetchMappedResponse() {
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        receivedData.value = LoadingState

        executor.execute {
            try {
                val response = useCase.execute()

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