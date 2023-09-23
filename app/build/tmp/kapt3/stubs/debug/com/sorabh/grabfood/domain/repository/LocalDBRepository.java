package com.sorabh.grabfood.domain.repository;

import com.sorabh.grabfood.domain.database.LocalDAO;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.util.QNAData;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u0014J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015J\u0019\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00150\u0014J\u0019\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0017J\u0019\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "", "localDAO", "Lcom/sorabh/grabfood/domain/database/LocalDAO;", "(Lcom/sorabh/grabfood/domain/database/LocalDAO;)V", "deleteMenu", "", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "(Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRestaurant", "restaurant", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "(Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMenuItem", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMenuList", "Lkotlinx/coroutines/flow/Flow;", "", "getQNAList", "Lcom/sorabh/grabfood/util/QNAData;", "getRestaurant", "getRestaurantList", "insertMenu", "insertQNAData", "qnaData", "insertRestaurant", "app_debug"})
public final class LocalDBRepository {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.database.LocalDAO localDAO = null;
    
    @javax.inject.Inject
    public LocalDBRepository(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.database.LocalDAO localDAO) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertRestaurant(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteRestaurant(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish>> getRestaurantList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRestaurant(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertMenu(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteMenu(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu>> getMenuList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMenuItem(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    public final void insertQNAData(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.util.QNAData qnaData) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.sorabh.grabfood.util.QNAData> getQNAList() {
        return null;
    }
}