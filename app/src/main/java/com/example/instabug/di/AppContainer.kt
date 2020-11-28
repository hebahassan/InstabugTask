package com.example.instabug.di

import android.app.Application
import com.example.instabug.data.di.DataContainer

class AppContainer(context: Application) {

    val dataContainer = DataContainer(context)

    var displayDataContainer: DisplayDataContainer? = null
}