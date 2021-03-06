package com.example.instabug.ui.datascreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.instabug.R
import com.example.instabug.app.InstabugApplication
import com.example.instabug.di.AppContainer
import com.example.instabug.di.DisplayDataContainer
import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.util.ErrorHandler
import com.example.instabug.viewmodel.ErrorState
import com.example.instabug.viewmodel.LoadingState
import com.example.instabug.viewmodel.SuccessState
import kotlinx.android.synthetic.main.activity_words_list.*

class DataActivity : AppCompatActivity() {

    private lateinit var appContainer: AppContainer
    private lateinit var viewModel: DataViewModel
    private val dataAdapter = DataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_list)

        appContainer = (application as InstabugApplication).appContainer
        appContainer.displayDataContainer = DisplayDataContainer(appContainer.dataContainer)
        viewModel = appContainer.displayDataContainer?.viewModelFactory?.create()!!

        viewModel.fetchMappedResponse()
        observeOnViewModel()
    }

    private fun observeOnViewModel() {
        viewModel.receivedData.observe(this, Observer {
            when(it) {
                LoadingState -> getLoadingStatus(true)

                is SuccessState -> handleSuccessState(it.data)

                is ErrorState -> handleErrorState()
            }
        })
    }

    private fun getLoadingStatus(status: Boolean) {
        when(status) {
            true -> progressBar.visibility = View.VISIBLE

            false -> progressBar.visibility = View.GONE
        }
    }

    private fun handleSuccessState(data: DisplayedDataModel) {
        getLoadingStatus(false)
        wordsRV.adapter = dataAdapter
        dataAdapter.updateHashMap(data.data)
    }

    private fun handleErrorState() {
        getLoadingStatus(false)
        val errorHandler = ErrorHandler(this)
        errorHandler.handleError()
    }
}