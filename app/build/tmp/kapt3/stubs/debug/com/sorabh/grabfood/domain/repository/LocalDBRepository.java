package com.sorabh.grabfood.domain.repository;

import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.domain.database.LocalDAO;
import com.sorabh.grabfood.util.QNAData;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "", "localDAO", "Lcom/sorabh/grabfood/domain/database/LocalDAO;", "(Lcom/sorabh/grabfood/domain/database/LocalDAO;)V", "deleteMenu", "", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "deleteRestaurant", "restaurant", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "getMenuItem", "id", "", "getMenuList", "", "getQNAList", "Lcom/sorabh/grabfood/util/QNAData;", "getRestaurant", "getRestaurantList", "insertMenu", "insertQNAData", "qnaData", "insertRestaurant", "app_debug"})
public final class LocalDBRepository {
    private final com.sorabh.grabfood.domain.database.LocalDAO localDAO = null;
    
    @javax.inject.Inject()
    public LocalDBRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.database.LocalDAO localDAO) {
        super();
    }
    
    public final void insertRestaurant(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant) {
    }
    
    public final void deleteRestaurant(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> getRestaurantList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.sorabh.grabfood.domain.model.reataurants_home_response.Dish getRestaurant(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public final void insertMenu(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu) {
    }
    
    public final void deleteMenu(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> getMenuList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu getMenuItem(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public final void insertQNAData(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.util.QNAData qnaData) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.sorabh.grabfood.util.QNAData> getQNAList() {
        return null;
    }
}