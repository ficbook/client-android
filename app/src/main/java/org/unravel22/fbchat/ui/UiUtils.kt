package org.unravel22.fbchat.ui

import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

/**
 * Created by admin on 01.09.17.
 */

val EditText.trimmedText: String
    get() = this.text.toString().trim()

var View.visible: Boolean
    get() = this.visibility == View.VISIBLE
    set(value) {
        this.visibility = if (value) View.VISIBLE else View.GONE
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

fun AppCompatActivity.setSupportActionBar(@IdRes toolbar: Int) = this.setSupportActionBar(this.findViewById(toolbar))