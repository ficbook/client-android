package org.unravel22.fbchat.ui

import android.content.Context
import android.content.Intent
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.EditText

/**
 * Created by admin on 01.09.17.
 */

val EditText.trimmedText: String
    get() = this.text.toString().trim()

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.shortSnackbar(@StringRes text: Int) {
    Snackbar.make(this, text, Snackbar.LENGTH_SHORT).show()
}

fun View.shortSnackbar(text: String) {
    Snackbar.make(this, text, Snackbar.LENGTH_SHORT).show()
}

fun Context.startActivity(cls: Class<*>) {
    this.startActivity(Intent(this, cls))
}