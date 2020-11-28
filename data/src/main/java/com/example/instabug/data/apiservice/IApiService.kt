package com.example.instabug.data.apiservice

import com.example.instabug.data.models.DataResponse

internal interface IApiService {

    fun fetchHtmlResponse(): DataResponse
}