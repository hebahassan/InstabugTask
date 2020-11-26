package com.example.instabug.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.instabug.R
import com.example.instabug.app.InstabugApplication
import com.example.instabug.util.ErrorHandler
import com.example.instabug.util.ErrorState
import com.example.instabug.util.LoadingState
import com.example.instabug.util.SuccessState
import kotlinx.android.synthetic.main.activity_words_list.*

class WordsListActivity : AppCompatActivity() {

    private lateinit var viewModel: WordsViewModel

    private val wordsAdapter = WordsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_list)

        val appContainer = (application as InstabugApplication).appContainer
        viewModel = appContainer.wordsViewModelFactory.create()

        observeOnViewModel()
    }

    private fun observeOnViewModel() {
        viewModel.receivedData.observe(this, Observer {
            when(it) {
                LoadingState -> getLoadingStatus(true)

                is SuccessState -> {
                    getLoadingStatus(false)
                    wordsRV.adapter = wordsAdapter
                    wordsAdapter.updateHashMap(it.data)
                }

                is ErrorState -> {
                    getLoadingStatus(false)
                    ErrorHandler.handleError(it.throwable.message ?: "No code", this)
                }
            }
        })
    }

    private fun getLoadingStatus(status: Boolean) {
        when(status) {
            true -> progressBar.visibility = View.VISIBLE

            false -> progressBar.visibility = View.GONE
        }
    }
}