package com.sorabh.grabfood.domain.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKey {
    val ADDRESS = stringPreferencesKey("address")
    val EMAIL = stringPreferencesKey("email")
    val MOBILE_NUMBER = stringPreferencesKey("mobile_number")
    val NAME = stringPreferencesKey("name")
    val USER_ID = stringPreferencesKey("user_id")
    val IS_LOGIN = booleanPreferencesKey("isLogin")
}