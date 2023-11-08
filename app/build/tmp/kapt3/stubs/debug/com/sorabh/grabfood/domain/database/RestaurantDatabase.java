package com.sorabh.grabfood.domain.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.util.QNAData;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sorabh/grabfood/domain/database/RestaurantDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getLocalDAO", "Lcom/sorabh/grabfood/domain/database/LocalDAO;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu.class, com.sorabh.grabfood.util.QNAData.class, com.sorabh.grabfood.domain.model.reataurants_home_response.Dish.class}, version = 2)
public abstract class RestaurantDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable
    private static com.sorabh.grabfood.domain.database.RestaurantDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String RESTAURANT_DB_NAME = "RESTAURANT_DATA";
    @org.jetbrains.annotations.NotNull
    public static final com.sorabh.grabfood.domain.database.RestaurantDatabase.Companion Companion = null;
    
    public RestaurantDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.sorabh.grabfood.domain.database.LocalDAO getLocalDAO();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/sorabh/grabfood/domain/database/RestaurantDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/sorabh/grabfood/domain/database/RestaurantDatabase;", "getINSTANCE", "()Lcom/sorabh/grabfood/domain/database/RestaurantDatabase;", "setINSTANCE", "(Lcom/sorabh/grabfood/domain/database/RestaurantDatabase;)V", "RESTAURANT_DB_NAME", "", "getRestaurantDatabaseInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.sorabh.grabfood.domain.database.RestaurantDatabase getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable
        com.sorabh.grabfood.domain.database.RestaurantDatabase p0) {
        }
        
        @kotlin.jvm.Synchronized
        @org.jetbrains.annotations.NotNull
        public final synchronized com.sorabh.grabfood.domain.database.RestaurantDatabase getRestaurantDatabaseInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}