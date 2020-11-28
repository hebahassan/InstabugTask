package com.example.instabug.data

import com.example.instabug.data.apiservice.IApiService
import com.example.instabug.data.datasource.RemoteDataSourceImpl
import com.example.instabug.domain.datasource.IRemoteDataSource
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
class RemoteDataSourceUnitTest {

    @Mock
    private lateinit var apiService: IApiService

    private var remoteSource: IRemoteDataSource? = null

    @Before
    fun setUp() {
        remoteSource = RemoteDataSourceImpl(apiService)
    }

    @After
    fun tearDown() {
        remoteSource = null
    }

    @Test
    fun testFetchingApiServiceData() {
        Mockito.`when`(apiService.fetchHtmlResponse()).thenReturn(MockData.dataResponse)

        val receivedData = remoteSource?.fetchRemoteData()

        assertEquals(receivedData, MockData.displayedDataModel)

        verify(apiService).fetchHtmlResponse()
        verifyNoMoreInteractions(apiService)
    }
}