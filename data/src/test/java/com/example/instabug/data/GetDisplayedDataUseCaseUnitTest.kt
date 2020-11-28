package com.example.instabug.data

import com.example.instabug.domain.repositories.IRepository
import com.example.instabug.domain.usecases.GetDisplayedDataUseCase
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetDisplayedDataUseCaseUnitTest {

    @Mock
    private lateinit var repository: IRepository

    private var useCase: GetDisplayedDataUseCase? = null

    @Before
    fun setUp() {
        useCase = GetDisplayedDataUseCase(repository)
    }

    @After
    fun tearDown() {
        useCase = null
    }

    @Test
    fun testExecuteRepoData() {
        Mockito.`when`(repository.fetchData()).thenReturn(MockData.displayedDataModel)

        val receivedData = useCase?.execute()

        assertEquals(receivedData, MockData.displayedDataModel)

        verify(repository).fetchData()
        verifyNoMoreInteractions(repository)
    }
}