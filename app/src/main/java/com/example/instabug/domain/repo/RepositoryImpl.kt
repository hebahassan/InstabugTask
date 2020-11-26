package com.example.instabug.domain.repo

import com.example.instabug.data.remote.IApiSource

class RepositoryImpl(private val apiSource: IApiSource): IRepository {

    override fun fetchHtmlResponse(): String = apiSource.fetchHtmlResponse()
}