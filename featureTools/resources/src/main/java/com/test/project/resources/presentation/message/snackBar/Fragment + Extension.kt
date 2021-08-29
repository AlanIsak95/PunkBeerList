package com.test.project.resources.presentation.message.snackBar

import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/** */
fun Fragment.showSnackbar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(view ?: return, message, duration).apply {
        val textView = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        textView.isSingleLine = false
        show()
    }
}