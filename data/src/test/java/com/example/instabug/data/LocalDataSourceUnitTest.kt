package com.example.instabug.data

import com.example.instabug.data.datasource.LocalDataSourceImpl
import com.example.instabug.data.db.data.WordsDao
import com.example.instabug.data.mappers.toDisplayedDataModel
import com.example.instabug.data.mappers.toWordsList
import com.example.instabug.domain.datasource.ILocalDataSource
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocalDataSourceUnitTest {

    @Mock
    private lateinit var dao: WordsDao

    private var localSource: ILocalDataSource? = null

    @Before
    fun setUp() {
        localSource = LocalDataSourceImpl(dao)
    }

    @After
    fun tearDown() {
        localSource = null
    }

    @Test
    fun testConvertingDisplayedDataToWordsList() {
        assertEquals(MockData.displayedDataModel.toWordsList(), MockData.wordsList)
    }

    @Test
    fun testConvertingWordsListToDisplayedData() {
        assertEquals(MockData.wordsList.toDisplayedDataModel(), MockData.wordsDataModel)
    }

    @Test
    fun testReplaceAllData() {
        doNothing().`when`(dao).replace(MockData.wordsList)

        localSource?.replaceWordsData(MockData.displayedDataModel)

        verify(dao).replace(MockData.wordsList)
        verifyNoMoreInteractions(dao)
    }

    @Test
    fun testDisplayAllData() {
        `when`(dao.selectAll()).thenReturn(MockData.wordsList)

        val receivedData = localSource?.displayWordsData()

        assertEquals(receivedData, MockData.wordsDataModel)

        verify(dao).selectAll()
        verifyNoMoreInteractions(dao)
    }
}