package com.example.instabug.data

import com.example.instabug.data.datasource.LocalDataSourceImpl
import com.example.instabug.data.db.data.WordsDao
import com.example.instabug.domain.datasource.ILocalDataSource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doNothing
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
    fun testReplaceAllData() {
//        doNothing().`when`(dao).replace(MockData.responseList)
    }

    @Test
    fun testDisplayAllData() {

    }
}