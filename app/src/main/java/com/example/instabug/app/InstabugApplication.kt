package com.example.instabug.app

import android.app.Application
import com.example.instabug.di.AppContainer

class InstabugApplication: Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()

        appContainer = AppContainer(this)
    }
}