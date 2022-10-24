package com.sorabh.grabfood.domain.di

import android.content.Context
import com.sorabh.grabfood.domain.database.LocalDAO
import com.sorabh.grabfood.domain.database.RestaurantDatabase
import com.sorabh.grabfood.domain.network_api.GetFoodClient
import com.sorabh.grabfood.domain.network_api.NetworkInterface
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofitClient(): Retrofit = GetFoodClient.getInstance()

    @Provides
    fun provideNetworkInterface(retrofit: Retrofit): NetworkInterface =
        retrofit.create(NetworkInterface::class.java)

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

}