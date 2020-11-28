package com.example.instabug.data

import com.example.instabug.common.network.INetworkProvider
import com.example.instabug.data.mappers.ignoreSpecialCharacters
import com.example.instabug.data.mappers.toDisplayedDataModel
import com.example.instabug.data.mappers.toStringList
import com.example.instabug.data.models.DataResponse
import com.example.instabug.data.repositories.RepositoryImpl
import com.example.instabug.domain.datasource.ILocalDataSource
import com.example.instabug.domain.datasource.IRemoteDataSource
import com.example.instabug.domain.models.DisplayedDataModel
import com.example.instabug.domain.repositories.IRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Assert.*
import org.mockito.Mockito.*

@RunWith(MockitoJUnitRunner::class)
class RepositoryUnitTest {

    @Mock
    private lateinit var localDataSource: ILocalDataSource
    @Mock
    private lateinit var remoteDataSource: IRemoteDataSource
    @Mock
    private lateinit var networkProvider: INetworkProvider

    private var repository: IRepository? = null

    @Before
    fun setUp() {
        repository = RepositoryImpl(remoteDataSource, localDataSource, networkProvider)
    }

    @After
    fun tearDown() {
        repository = null
    }

    @Test
    fun testIgnoreSpecialCharacters() {
        assertEquals(MockData.htmlResponse.ignoreSpecialCharacters(), MockData.dataResponse.response)
    }

    @Test
    fun testConvertStringToStringList() {
        assertEquals(MockData.dataResponse.response.toStringList(), MockData.responseList)
    }

    @Test
    fun testMappingDataToDisplayedDataModel() {
        assertEquals(MockData.dataResponse.toDisplayedDataModel(), MockData.displayedDataModel)
    }

    @Test
    fun testFetchResponseRemotely() {
        `when`(networkProvider.isConnected()).thenReturn(true)
        doNothing().`when`(localDataSource).replaceWordsData(MockData.displayedDataModel)
        `when`(remoteDataSource.fetchRemoteData()).thenReturn(MockData.displayedDataModel)

        val receivedData = repository?.fetchData()

        assertEquals(receivedData, MockData.displayedDataModel)

        verify(networkProvider).isConnected()
        verify(localDataSource).replaceWordsData(MockData.displayedDataModel)
        verify(remoteDataSource).fetchRemoteData()

        verifyNoMoreInteractions(networkProvider)
        verifyNoMoreInteractions(localDataSource)
        verifyNoMoreInteractions(remoteDataSource)
    }

    @Test
    fun testFetchResponseLocally() {
        `when`(networkProvider.isConnected()).thenReturn(false)
        `when`(localDataSource.displayWordsData()).thenReturn(MockData.displayedDataModel)

        val receivedData = repository?.fetchData()

        assertEquals(receivedData, MockData.displayedDataModel)

        verify(networkProvider).isConnected()
        verify(localDataSource).displayWordsData()

        verifyNoMoreInteractions(networkProvider)
        verifyNoMoreInteractions(localDataSource)
        verifyZeroInteractions(remoteDataSource)
    }
}