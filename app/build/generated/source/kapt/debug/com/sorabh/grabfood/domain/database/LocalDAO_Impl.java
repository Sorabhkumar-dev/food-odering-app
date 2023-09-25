package com.sorabh.grabfood.domain.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.util.QNAData;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LocalDAO_Impl implements LocalDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Dish> __insertionAdapterOfDish;

  private final EntityInsertionAdapter<Menu> __insertionAdapterOfMenu;

  private final EntityDeletionOrUpdateAdapter<Dish> __deletionAdapterOfDish;

  private final EntityDeletionOrUpdateAdapter<Menu> __deletionAdapterOfMenu;

  private final EntityDeletionOrUpdateAdapter<QNAData> __deletionAdapterOfQNAData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllMenu;

  private final EntityUpsertionAdapter<QNAData> __upsertionAdapterOfQNAData;

  public LocalDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDish = new EntityInsertionAdapter<Dish>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Restaurant` (`cost_for_one`,`id`,`image_url`,`name`,`rating`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Dish value) {
        if (value.getCost_for_one() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCost_for_one());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getId());
        }
        if (value.getImage_url() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImage_url());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getRating() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRating());
        }
      }
    };
    this.__insertionAdapterOfMenu = new EntityInsertionAdapter<Menu>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Menu` (`cost_for_one`,`id`,`name`,`restaurant_id`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Menu value) {
        if (value.getCost_for_one() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCost_for_one());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getRestaurant_id() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRestaurant_id());
        }
      }
    };
    this.__deletionAdapterOfDish = new EntityDeletionOrUpdateAdapter<Dish>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Restaurant` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Dish value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__deletionAdapterOfMenu = new EntityDeletionOrUpdateAdapter<Menu>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Menu` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Menu value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__deletionAdapterOfQNAData = new EntityDeletionOrUpdateAdapter<QNAData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `QNA_TABLE` WHERE `sno` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QNAData value) {
        stmt.bindLong(1, value.getSno());
      }
    };
    this.__preparedStmtOfDeleteAllMenu = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from menu where restaurant_id =?";
        return _query;
      }
    };
    this.__upsertionAdapterOfQNAData = new EntityUpsertionAdapter<QNAData>(new EntityInsertionAdapter<QNAData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT INTO `QNA_TABLE` (`sno`,`question`,`answer`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QNAData value) {
        stmt.bindLong(1, value.getSno());
        if (value.getQuestion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getQuestion());
        }
        if (value.getAnswer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAnswer());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<QNAData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE `QNA_TABLE` SET `sno` = ?,`question` = ?,`answer` = ? WHERE `sno` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QNAData value) {
        stmt.bindLong(1, value.getSno());
        if (value.getQuestion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getQuestion());
        }
        if (value.getAnswer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAnswer());
        }
        stmt.bindLong(4, value.getSno());
      }
    });
  }

  @Override
  public Object insertRestaurant(final Dish restaurant,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDish.insert(restaurant);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertMenu(final Menu menu, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMenu.insert(menu);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRestaurant(final Dish restaurant,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDish.handle(restaurant);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMenu(final Menu menu, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMenu.handle(menu);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public void deleteQNAData(final QNAData qnaData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfQNAData.handle(qnaData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object deleteAllMenu(final String restaurant_id,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllMenu.acquire();
        int _argIndex = 1;
        if (restaurant_id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, restaurant_id);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllMenu.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public void upsertQNAs(final List<QNAData> questions) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfQNAData.upsert(questions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<List<Dish>> getRestaurantList() {
    final String _sql = "Select * from Restaurant";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Restaurant"}, new Callable<List<Dish>>() {
      @Override
      public List<Dish> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCostForOne = CursorUtil.getColumnIndexOrThrow(_cursor, "cost_for_one");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final List<Dish> _result = new ArrayList<Dish>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Dish _item;
            final String _tmpCost_for_one;
            if (_cursor.isNull(_cursorIndexOfCostForOne)) {
              _tmpCost_for_one = null;
            } else {
              _tmpCost_for_one = _cursor.getString(_cursorIndexOfCostForOne);
            }
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpImage_url;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImage_url = null;
            } else {
              _tmpImage_url = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getString(_cursorIndexOfRating);
            }
            _item = new Dish(_tmpCost_for_one,_tmpId,_tmpImage_url,_tmpName,_tmpRating);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getRestaurant(final String id, final Continuation<? super Integer> $completion) {
    final String _sql = "select Count(id) from Restaurant where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMenuItem(final String id, final Continuation<? super Integer> $completion) {
    final String _sql = "select Count(id) from menu where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Menu>> getMenuList() {
    final String _sql = "Select * from menu";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"menu"}, new Callable<List<Menu>>() {
      @Override
      public List<Menu> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCostForOne = CursorUtil.getColumnIndexOrThrow(_cursor, "cost_for_one");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRestaurantId = CursorUtil.getColumnIndexOrThrow(_cursor, "restaurant_id");
          final List<Menu> _result = new ArrayList<Menu>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Menu _item;
            final String _tmpCost_for_one;
            if (_cursor.isNull(_cursorIndexOfCostForOne)) {
              _tmpCost_for_one = null;
            } else {
              _tmpCost_for_one = _cursor.getString(_cursorIndexOfCostForOne);
            }
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpRestaurant_id;
            if (_cursor.isNull(_cursorIndexOfRestaurantId)) {
              _tmpRestaurant_id = null;
            } else {
              _tmpRestaurant_id = _cursor.getString(_cursorIndexOfRestaurantId);
            }
            _item = new Menu(_tmpCost_for_one,_tmpId,_tmpName,_tmpRestaurant_id);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<QNAData> getQNAList() {
    final String _sql = "select * from QNA_TABLE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSno = CursorUtil.getColumnIndexOrThrow(_cursor, "sno");
      final int _cursorIndexOfQuestion = CursorUtil.getColumnIndexOrThrow(_cursor, "question");
      final int _cursorIndexOfAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "answer");
      final List<QNAData> _result = new ArrayList<QNAData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final QNAData _item;
        final int _tmpSno;
        _tmpSno = _cursor.getInt(_cursorIndexOfSno);
        final String _tmpQuestion;
        if (_cursor.isNull(_cursorIndexOfQuestion)) {
          _tmpQuestion = null;
        } else {
          _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
        }
        final String _tmpAnswer;
        if (_cursor.isNull(_cursorIndexOfAnswer)) {
          _tmpAnswer = null;
        } else {
          _tmpAnswer = _cursor.getString(_cursorIndexOfAnswer);
        }
        _item = new QNAData(_tmpSno,_tmpQuestion,_tmpAnswer);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
