package com.example.instabug.data.remote

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import javax.net.ssl.HttpsURLConnection

class ApiSourceImpl(private val requestUrl: String): IApiSource {

    override fun fetchHtmlResponse(): String {
        val content = StringBuilder()

        try {
            val url = URL(requestUrl)
            val connection = url.openConnection() as HttpURLConnection

            when (connection.responseCode) {
                HttpsURLConnection.HTTP_OK -> {
                    val br = BufferedReader(
                            InputStreamReader(
                                    connection.inputStream,
                                    Charset.forName("UTF-8")
                            )
                    )
                    var line: String?

                    while (br.readLine().also { line = it } != null) {
                        content.append(line).append("\n")
                    }
                }

                else -> {
                    throw IOException("${connection.responseCode}")
                }
            }
        } catch (e: StackOverflowError) {
            e.printStackTrace()
            throw IOException("Something wrong")
        } catch (e: Exception) {
            e.printStackTrace()
            throw IOException("500")
        } catch (e: Error) {
            e.printStackTrace()
            throw IOException("Something wrong")
        }

        return content.toString()
    }
}