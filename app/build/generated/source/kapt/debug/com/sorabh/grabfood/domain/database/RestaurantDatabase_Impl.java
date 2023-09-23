package com.sorabh.grabfood.domain.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RestaurantDatabase_Impl extends RestaurantDatabase {
  private volatile LocalDAO _localDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Menu` (`cost_for_one` TEXT NOT NULL, `id` TEXT NOT NULL, `name` TEXT NOT NULL, `restaurant_id` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `QNA_TABLE` (`sno` INTEGER NOT NULL, `question` TEXT NOT NULL, `answer` TEXT NOT NULL, PRIMARY KEY(`sno`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Restaurant` (`cost_for_one` TEXT NOT NULL, `id` TEXT NOT NULL, `image_url` TEXT NOT NULL, `name` TEXT NOT NULL, `rating` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f5009fe12c72ad66594a073947bad646')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Menu`");
        _db.execSQL("DROP TABLE IF EXISTS `QNA_TABLE`");
        _db.execSQL("DROP TABLE IF EXISTS `Restaurant`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMenu = new HashMap<String, TableInfo.Column>(4);
        _columnsMenu.put("cost_for_one", new TableInfo.Column("cost_for_one", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenu.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenu.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenu.put("restaurant_id", new TableInfo.Column("restaurant_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMenu = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMenu = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMenu = new TableInfo("Menu", _columnsMenu, _foreignKeysMenu, _indicesMenu);
        final TableInfo _existingMenu = TableInfo.read(_db, "Menu");
        if (! _infoMenu.equals(_existingMenu)) {
          return new RoomOpenHelper.ValidationResult(false, "Menu(com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu).\n"
                  + " Expected:\n" + _infoMenu + "\n"
                  + " Found:\n" + _existingMenu);
        }
        final HashMap<String, TableInfo.Column> _columnsQNATABLE = new HashMap<String, TableInfo.Column>(3);
        _columnsQNATABLE.put("sno", new TableInfo.Column("sno", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQNATABLE.put("question", new TableInfo.Column("question", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQNATABLE.put("answer", new TableInfo.Column("answer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQNATABLE = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQNATABLE = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQNATABLE = new TableInfo("QNA_TABLE", _columnsQNATABLE, _foreignKeysQNATABLE, _indicesQNATABLE);
        final TableInfo _existingQNATABLE = TableInfo.read(_db, "QNA_TABLE");
        if (! _infoQNATABLE.equals(_existingQNATABLE)) {
          return new RoomOpenHelper.ValidationResult(false, "QNA_TABLE(com.sorabh.grabfood.util.QNAData).\n"
                  + " Expected:\n" + _infoQNATABLE + "\n"
                  + " Found:\n" + _existingQNATABLE);
        }
        final HashMap<String, TableInfo.Column> _columnsRestaurant = new HashMap<String, TableInfo.Column>(5);
        _columnsRestaurant.put("cost_for_one", new TableInfo.Column("cost_for_one", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRestaurant.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRestaurant.put("image_url", new TableInfo.Column("image_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRestaurant.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRestaurant.put("rating", new TableInfo.Column("rating", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRestaurant = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRestaurant = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRestaurant = new TableInfo("Restaurant", _columnsRestaurant, _foreignKeysRestaurant, _indicesRestaurant);
        final TableInfo _existingRestaurant = TableInfo.read(_db, "Restaurant");
        if (! _infoRestaurant.equals(_existingRestaurant)) {
          return new RoomOpenHelper.ValidationResult(false, "Restaurant(com.sorabh.grabfood.domain.model.reataurants_home_response.Dish).\n"
                  + " Expected:\n" + _infoRestaurant + "\n"
                  + " Found:\n" + _existingRestaurant);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f5009fe12c72ad66594a073947bad646", "83db2a828b4146e79d86e1f21cede446");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Menu","QNA_TABLE","Restaurant");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Menu`");
      _db.execSQL("DELETE FROM `QNA_TABLE`");
      _db.execSQL("DELETE FROM `Restaurant`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LocalDAO.class, LocalDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public LocalDAO getLocalDAO() {
    if (_localDAO != null) {
      return _localDAO;
    } else {
      synchronized(this) {
        if(_localDAO == null) {
          _localDAO = new LocalDAO_Impl(this);
        }
        return _localDAO;
      }
    }
  }
}
