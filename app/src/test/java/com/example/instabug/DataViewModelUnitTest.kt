package com.example.instabug

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRepository
import com.example.instabug.domain.usecases.GetDisplayedDataUseCase
import com.example.instabug.ui.datascreen.DataViewModel
import com.example.instabug.viewmodel.LoadingState
import com.example.instabug.viewmodel.SuccessState
import com.example.instabug.viewmodel.ViewModelState
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors


@RunWith(MockitoJUnitRunner::class)
class DataViewModelUnitTest {

    @Rule
    @JvmField
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: IRepository

    @Mock
    lateinit var observer: Observer<ViewModelState>

    private var useCase: GetDisplayedDataUseCase? = null
    private var viewModel: DataViewModel? = null

    @Before
    fun setUp() {
        useCase = GetDisplayedDataUseCase(repository)
        viewModel = DataViewModel(useCase!!)
        viewModel?.receivedData?.observeForever(observer)
    }

    @After
    fun tearDown() {
        viewModel = null
    }

    @Test
    fun testViewModelFetchDataSuccessfully() {
        `when`(useCase?.execute()).thenReturn(MockData.displayedDataModel)

        viewModel?.fetchMappedResponse()

        verify(observer).onChanged(LoadingState)

        val data = CompletableFuture<DisplayedDataModel>()
        val liveData = CompletableFuture<ViewModelState>()

        Executors.newSingleThreadExecutor().submit {
            data.complete(useCase?.execute())
            liveData.complete(SuccessState(data.get()))
        }

        assertEquals(data.get(), MockData.displayedDataModel)
        assertEquals(liveData.get(), SuccessState(MockData.displayedDataModel))
    }
}