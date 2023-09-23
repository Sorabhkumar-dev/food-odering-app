package com.sorabh.grabfood.domain.di;

import android.content.Context;
import com.sorabh.grabfood.domain.database.LocalDAO;
import com.sorabh.grabfood.domain.database.RestaurantDatabase;
import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.datastore.PreferenceDataImpl;
import com.sorabh.grabfood.domain.network_api.NetworkInterface;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl;
import com.sorabh.grabfood.util.Constants;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0017\u001a\u00020\u0011H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/sorabh/grabfood/domain/di/AppModule;", "", "()V", "provideContext", "Landroid/content/Context;", "context", "provideDao", "Lcom/sorabh/grabfood/domain/database/LocalDAO;", "db", "Lcom/sorabh/grabfood/domain/database/RestaurantDatabase;", "provideDataStore", "Lcom/sorabh/grabfood/domain/datastore/PreferenceData;", "preferenceData", "Lcom/sorabh/grabfood/domain/datastore/PreferenceDataImpl;", "provideNetworkInterface", "Lcom/sorabh/grabfood/domain/network_api/NetworkInterface;", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideNetworkRepository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "networkRepositoryImpl", "Lcom/sorabh/grabfood/domain/repository/NetworkRepositoryImpl;", "provideRestaurantDb", "providesUserOkHttpClient", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient providesUserOkHttpClient() {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.domain.network_api.NetworkInterface provideNetworkInterface(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.domain.repository.NetworkRepository provideNetworkRepository(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl networkRepositoryImpl) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final android.content.Context provideContext(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.domain.database.RestaurantDatabase provideRestaurantDb(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.domain.database.LocalDAO provideDao(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.database.RestaurantDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.domain.datastore.PreferenceData provideDataStore(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.datastore.PreferenceDataImpl preferenceData) {
        return null;
    }
}