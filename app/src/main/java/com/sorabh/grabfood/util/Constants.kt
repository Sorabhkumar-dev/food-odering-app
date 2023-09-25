package com.sorabh.grabfood.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Constants {
    const val NETWORK_ERROR = "Something went wrong!"
    const val MAIN_TOKEN = "025c40375fadfd"
    const val CONTENT_TYPE_VALUE = "application/json"
    const val BASE_URL = "http://13.235.250.119/v2/"
    const val PREFERENCE_DATA_STORE = "grab_data_store"
    const val LOGIN = "login"

    fun getDate(str:String):String{
        val date =  SimpleDateFormat("dd-mm-yy HH:mm:ss", Locale.getDefault()).parse(str) ?: Date()
        return  SimpleDateFormat("HH:mm dd-MMM-yyyy", Locale.getDefault()).format(date)
    }
}