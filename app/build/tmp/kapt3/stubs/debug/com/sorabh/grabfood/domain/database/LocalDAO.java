package com.sorabh.grabfood.domain.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.util.QNAData;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\'J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00170\u0016H\'J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\'J\u0019\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00170\u0016H\'J\u0019\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\'J\u0019\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/sorabh/grabfood/domain/database/LocalDAO;", "", "deleteAllMenu", "", "restaurant_id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMenu", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "(Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteQNAData", "qnaData", "Lcom/sorabh/grabfood/util/QNAData;", "deleteRestaurant", "restaurant", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "(Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMenuItem", "", "id", "getMenuList", "Lkotlinx/coroutines/flow/Flow;", "", "getQNAList", "getRestaurant", "getRestaurantList", "insertMenu", "insertQNAData", "insertRestaurant", "app_debug"})
@androidx.room.Dao
public abstract interface LocalDAO {
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertRestaurant(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRestaurant(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "Select * from Restaurant")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish>> getRestaurantList();
    
    @androidx.room.Query(value = "select Count(id) from Restaurant where id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRestaurant(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertMenu(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "select Count(id) from menu where id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMenuItem(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMenu(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "delete from menu where restaurant_id =:restaurant_id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllMenu(@org.jetbrains.annotations.NotNull
    java.lang.String restaurant_id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "Select * from menu")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu>> getMenuList();
    
    @androidx.room.Insert
    public abstract void insertQNAData(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.util.QNAData qnaData);
    
    @androidx.room.Delete
    public abstract void deleteQNAData(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.util.QNAData qnaData);
    
    @androidx.room.Query(value = "select * from QNA_TABLE")
    @org.jetbrains.annotations.Nullable
    public abstract java.util.List<com.sorabh.grabfood.util.QNAData> getQNAList();
}