package com.example.instabug.util

import android.content.Context
import android.widget.Toast

object ErrorHandler {

    fun handleError(context: Context) {
        Toast.makeText(context, "Error in fetching data.. Please retry", Toast.LENGTH_SHORT).show()
    }
}