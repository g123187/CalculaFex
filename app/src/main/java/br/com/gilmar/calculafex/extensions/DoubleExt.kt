package br.com.gilmar.calculafex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)