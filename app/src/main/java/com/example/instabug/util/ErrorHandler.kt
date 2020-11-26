package com.example.instabug.util

import android.content.Context
import android.widget.Toast

object ErrorHandler {

    fun handleError(error: String, context: Context) {
        when(error) {
            "500" -> {
                //TODO: load from database
                Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show()
            }

            else -> {
                //TODO: build a retry dialog
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}