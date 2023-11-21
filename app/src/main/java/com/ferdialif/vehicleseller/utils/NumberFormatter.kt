package com.ferdialif.vehicleseller.utils

import java.text.NumberFormat
import java.util.Locale

fun Double.toProperNumberFormat(): String {
    return NumberFormat.getCurrencyInstance(Locale("id","ID")).format(this)
}