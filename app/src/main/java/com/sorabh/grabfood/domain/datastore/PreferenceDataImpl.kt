package com.sorabh.grabfood.domain.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.sorabh.grabfood.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceDataImpl @Inject constructor(private val context: Context) : PreferenceData {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = Constants.PREFERENCE_DATA_STORE,
        produceMigrations = { context ->
            listOf(SharedPreferencesMigration(context, Constants.LOGIN))
        })

    override suspend fun writeAddress(address: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKey.ADDRESS] = address
        }
    }

    override suspend fun writeEmail(email: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKey.EMAIL] = email
        }
    }

    override suspend fun writeMobileNumber(mobileNumber: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKey.MOBILE_NUMBER] = mobileNumber
        }
    }

    override suspend fun writeName(name: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKey.NAME] = name
        }
    }

    override suspend fun writeUserId(userId: String) {
        context.dataStore.edit { preference ->
            preference[PreferenceKey.USER_ID] = userId
        }
    }

    override suspend fun writeIsLogin(isLogin: Boolean) {
        context.dataStore.edit { preference ->
            preference[PreferenceKey.IS_LOGIN] = isLogin
        }
    }

    override val readAddressFlow: Flow<String> = context.dataStore.data.catch {
        if (this is Exception) emit(
            emptyPreferences()
        )
    }
        .map { preference ->
            preference[PreferenceKey.ADDRESS] ?: ""
        }

    override val readEmailFlow: Flow<String> = context.dataStore.data.catch {
        if (this is Exception) emit(emptyPreferences())
    }.map { preference ->
        preference[PreferenceKey.EMAIL] ?: ""
    }

    override val readMobileNumberFlow: Flow<String> = context.dataStore.data.catch {
        if (this is Exception) emit(emptyPreferences())
    }.map { preference ->
        preference[PreferenceKey.MOBILE_NUMBER] ?: ""
    }
    override val readNameFlow: Flow<String> = context.dataStore.data.catch {
        if (this is Exception) emit(emptyPreferences())
    }.map { preference ->
        preference[PreferenceKey.NAME] ?: ""
    }

    override val readUserIdFlow: Flow<String> = context.dataStore.data.catch {
        if (this is Exception) emit(emptyPreferences())
    }.map { preference ->
        preference[PreferenceKey.USER_ID] ?: ""
    }

    override val readIsLoginFlow: Flow<Boolean> = context.dataStore.data.catch {
        if (this is Exception) emit(emptyPreferences())
    }.map { preference ->
        preference[PreferenceKey.IS_LOGIN] ?: false
    }
}