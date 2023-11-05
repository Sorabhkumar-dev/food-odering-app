package com.sorabh.grabfood.domain.repository;

import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.util.QNAData;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\fH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\fH&J\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0017\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "", "deleteMenu", "", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "(Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRestaurant", "dish", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "(Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMenuItem", "Lkotlinx/coroutines/flow/Flow;", "", "id", "", "getMenuList", "", "getQNAList", "Lcom/sorabh/grabfood/util/QNAData;", "getRestaurant", "getRestaurantList", "insertMenu", "insertRestaurant", "upsertQNAs", "questions", "app_debug"})
public abstract interface LocalDBRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertRestaurant(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRestaurant(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish>> getRestaurantList();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getRestaurant(@org.jetbrains.annotations.NotNull
    java.lang.String id);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertMenu(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMenu(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu>> getMenuList();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getMenuItem(@org.jetbrains.annotations.NotNull
    java.lang.String id);
    
    public abstract void upsertQNAs(@org.jetbrains.annotations.NotNull
    java.util.List<com.sorabh.grabfood.util.QNAData> questions);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.sorabh.grabfood.util.QNAData> getQNAList();
}