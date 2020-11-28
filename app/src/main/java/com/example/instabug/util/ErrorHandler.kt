package com.example.instabug.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.example.instabug.R
import com.example.instabug.common.errors.IErrorHandler
import kotlinx.android.synthetic.main.layout_error_dialog.*

class ErrorHandler(private val context: Context): IErrorHandler {

    override fun handleError() {

        val dialog = Dialog(context, R.style.DialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_error_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.contentTV.text = context.getString(R.string.dialog_error)

        dialog.cancelBT.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }
}