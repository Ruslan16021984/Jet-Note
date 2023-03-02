package com.card3333333.jetnoteapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d, MMM", Locale.getDefault())
    return format.format(date)
}