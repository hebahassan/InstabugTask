package com.example.instabug.data.remote

interface IApiSource {

    fun fetchHtmlResponse(): String
}