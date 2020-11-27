package com.example.instabug.di

import com.example.instabug.data.di.DataContainer

class AppContainer {

    val dataContainer = DataContainer()
    var displayDataContainer: DisplayDataContainer? = null
}