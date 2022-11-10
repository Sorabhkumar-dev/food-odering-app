package com.sorabh.grabfood.domain.di

import android.content.Context
import com.sorabh.grabfood.domain.database.LocalDAO
import com.sorabh.grabfood.domain.database.RestaurantDatabase
import com.sorabh.grabfood.domain.datastore.PreferenceData
import com.sorabh.grabfood.domain.datastore.PreferenceDataImpl
import com.sorabh.grabfood.domain.network_api.NetworkInterface
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl
import com.sorabh.grabfood.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesUserOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            interceptors().add(Interceptor { chain ->
                val builder = chain.request().newBuilder()
                    .addHeader("Content-type", "application/json; charset=UTF-8")
                    .addHeader("Accept", "application/json")
                chain.proceed(builder.build())
            })
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
        }.build()


    @Provides
    fun provideNetworkInterface(okHttpClient: OkHttpClient): NetworkInterface =
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build().create(NetworkInterface::class.java)


    @Provides
    fun provideNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository =
        networkRepositoryImpl

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideRestaurantDb(context: Context): RestaurantDatabase =
        RestaurantDatabase.getRestaurantDatabaseInstance(context)

    @Provides
    fun provideDao(db:RestaurantDatabase):LocalDAO = db.getLocalDAO()

    @Provides
    @Singleton
    fun provideDataStore(preferenceData:PreferenceDataImpl):PreferenceData = preferenceData
}