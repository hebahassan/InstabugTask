package com.example.instabug.domain.repositories

import com.example.instabug.domain.models.DisplayedDataModel

interface IRepository {

    fun fetchData(): DisplayedDataModel
}