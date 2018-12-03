package br.com.gilmar.calculafex.extensions

import android.widget.EditText

fun EditText.getDouble() : Double{
    return this.text.toString().toDouble()
}

fun EditText.getString(): String{
    return this.text.toString()}
