package com.example.instabug.di

interface Factory<T> {

    fun create(): T
}