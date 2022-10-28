package com.sorabh.grabfood.domain.di;

import android.content.Context;
import com.sorabh.grabfood.domain.database.LocalDAO;
import com.sorabh.grabfood.domain.database.RestaurantDatabase;
import com.sorabh.grabfood.domain.network_api.GetFoodClient;
import com.sorabh.grabfood.domain.network_api.NetworkInterface;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\rH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/sorabh/grabfood/domain/di/AppModule;", "", "()V", "provideContext", "Landroid/content/Context;", "context", "provideDao", "Lcom/sorabh/grabfood/domain/database/LocalDAO;", "db", "Lcom/sorabh/grabfood/domain/database/RestaurantDatabase;", "provideNetworkInterface", "Lcom/sorabh/grabfood/domain/network_api/NetworkInterface;", "retrofit", "Lretrofit2/Retrofit;", "provideNetworkRepository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "networkRepositoryImpl", "Lcom/sorabh/grabfood/domain/repository/NetworkRepositoryImpl;", "provideRestaurantDb", "provideRetrofitClient", "app_debug"})
@dagger.Module()
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofitClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.sorabh.grabfood.domain.network_api.NetworkInterface provideNetworkInterface(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.sorabh.grabfood.domain.repository.NetworkRepository provideNetworkRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl networkRepositoryImpl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.content.Context provideContext(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.sorabh.grabfood.domain.database.RestaurantDatabase provideRestaurantDb(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.sorabh.grabfood.domain.database.LocalDAO provideDao(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.database.RestaurantDatabase db) {
        return null;
    }
}