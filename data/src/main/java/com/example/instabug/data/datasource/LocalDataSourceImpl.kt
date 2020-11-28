package com.example.instabug.data.datasource

import com.example.instabug.data.db.data.WordsDao
import com.example.instabug.data.mappers.toDisplayedDataModel
import com.example.instabug.data.mappers.toWordsList
import com.example.instabug.domain.datasource.ILocalDataSource
import com.example.instabug.domain.models.DisplayedDataModel

internal class LocalDataSourceImpl(private val wordsDao: WordsDao): ILocalDataSource {

    override fun replaceWordsData(data: DisplayedDataModel) {
        wordsDao.replace(data.toWordsList())
    }

    override fun displayWordsData(): DisplayedDataModel {
        val wordsList = wordsDao.selectAll()
        return wordsList.toDisplayedDataModel()
    }
}