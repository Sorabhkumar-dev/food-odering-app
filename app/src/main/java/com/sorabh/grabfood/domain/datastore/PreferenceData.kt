package com.sorabh.grabfood.domain.datastore

import kotlinx.coroutines.flow.Flow

interface PreferenceData {
    suspend fun writeAddress(address:String)

    suspend fun writeEmail(email:String)

    suspend fun writeMobileNumber(mobileNumber:String)

    suspend fun writeName(name:String)

    suspend fun writeUserId(userId:String)

    suspend fun writeIsLogin(isLogin:Boolean)

    suspend fun writeDarkMode(isOnDarkMode:Boolean)

    suspend fun clearDatStore()

    val readAddressFlow:Flow<String>

    val readEmailFlow:Flow<String>

    val readMobileNumberFlow:Flow<String>

    val readNameFlow:Flow<String>

    val readUserIdFlow:Flow<String>

    val readIsLoginFlow:Flow<Boolean>

    val readLightModeFlow:Flow<Boolean>
}