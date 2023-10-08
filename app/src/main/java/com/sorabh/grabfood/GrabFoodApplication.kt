package com.sorabh.grabfood

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GrabFoodApplication : Application() {

    companion object {
        fun Context.R(): Resources = applicationContext.resources
    }
}