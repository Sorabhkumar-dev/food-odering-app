package com.sorabh.grabfood.domain.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.util.QNAData;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0005H\'J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\'J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\'J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\'J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012H\'J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u0019"}, d2 = {"Lcom/sorabh/grabfood/domain/database/LocalDAO;", "", "deleteAllMenu", "", "restaurant_id", "", "deleteMenu", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "deleteQNAData", "qnaData", "Lcom/sorabh/grabfood/util/QNAData;", "deleteRestaurant", "restaurant", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "getMenuItem", "id", "getMenuList", "", "getQNAList", "getRestaurant", "getRestaurantList", "insertMenu", "insertQNAData", "insertRestaurant", "app_debug"})
public abstract interface LocalDAO {
    
    @androidx.room.Insert()
    public abstract void insertRestaurant(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant);
    
    @androidx.room.Delete()
    public abstract void deleteRestaurant(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish restaurant);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Select * from Restaurant")
    public abstract java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> getRestaurantList();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from Restaurant where id = :id")
    public abstract com.sorabh.grabfood.domain.model.reataurants_home_response.Dish getRestaurant(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Insert()
    public abstract void insertMenu(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu);
    
    @androidx.room.Delete()
    public abstract void deleteMenu(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu);
    
    @androidx.room.Query(value = "delete from menu where restaurant_id =:restaurant_id")
    public abstract void deleteAllMenu(@org.jetbrains.annotations.NotNull()
    java.lang.String restaurant_id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Select * from menu")
    public abstract java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> getMenuList();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from menu where id = :id")
    public abstract com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu getMenuItem(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Insert()
    public abstract void insertQNAData(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.util.QNAData qnaData);
    
    @androidx.room.Delete()
    public abstract void deleteQNAData(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.util.QNAData qnaData);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from QNA_TABLE")
    public abstract java.util.List<com.sorabh.grabfood.util.QNAData> getQNAList();
}