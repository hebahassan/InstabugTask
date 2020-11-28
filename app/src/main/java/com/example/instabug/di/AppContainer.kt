package com.example.instabug.di

import android.app.Application
import com.example.instabug.data.di.DataContainer

class AppContainer {

    var context: Application? = null

    val dataContainer = DataContainer(context!!)

    var displayDataContainer: DisplayDataContainer? = null
}