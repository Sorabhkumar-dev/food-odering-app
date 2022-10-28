package com.sorabh.grabfood;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sorabh.grabfood.databinding.CartAdapterLayoutBindingImpl;
import com.sorabh.grabfood.databinding.FoodItemCardViewBindingImpl;
import com.sorabh.grabfood.databinding.FragmentQNABindingImpl;
import com.sorabh.grabfood.databinding.HeaderLayoutBindingImpl;
import com.sorabh.grabfood.databinding.OderBottomSheetBindingImpl;
import com.sorabh.grabfood.databinding.OderHistotoyCardviewBindingImpl;
import com.sorabh.grabfood.databinding.QNACardViewBindingImpl;
import com.sorabh.grabfood.databinding.RestaurantMenuCardviewBindingImpl;
import com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBindingImpl;
import com.sorabh.grabfood.databinding.SignUpFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CARTADAPTERLAYOUT = 1;

  private static final int LAYOUT_FOODITEMCARDVIEW = 2;

  private static final int LAYOUT_FRAGMENTQNA = 3;

  private static final int LAYOUT_HEADERLAYOUT = 4;

  private static final int LAYOUT_ODERBOTTOMSHEET = 5;

  private static final int LAYOUT_ODERHISTOTOYCARDVIEW = 6;

  private static final int LAYOUT_QNACARDVIEW = 7;

  private static final int LAYOUT_RESTAURANTMENUCARDVIEW = 8;

  private static final int LAYOUT_RESTAURANTSHOMECARDVIEW = 9;

  private static final int LAYOUT_SIGNUPFRAGMENT = 10;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(10);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.cart_adapter_layout, LAYOUT_CARTADAPTERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.food_item_card_view, LAYOUT_FOODITEMCARDVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.fragment_q_n_a, LAYOUT_FRAGMENTQNA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.header_layout, LAYOUT_HEADERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.oder_bottom_sheet, LAYOUT_ODERBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.oder_histotoy_cardview, LAYOUT_ODERHISTOTOYCARDVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.q_n_a_card_view, LAYOUT_QNACARDVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.restaurant_menu_cardview, LAYOUT_RESTAURANTMENUCARDVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.restaurants_home_cardview, LAYOUT_RESTAURANTSHOMECARDVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sorabh.grabfood.R.layout.sign_up_fragment, LAYOUT_SIGNUPFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CARTADAPTERLAYOUT: {
          if ("layout/cart_adapter_layout_0".equals(tag)) {
            return new CartAdapterLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cart_adapter_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_FOODITEMCARDVIEW: {
          if ("layout/food_item_card_view_0".equals(tag)) {
            return new FoodItemCardViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for food_item_card_view is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTQNA: {
          if ("layout/fragment_q_n_a_0".equals(tag)) {
            return new FragmentQNABindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_q_n_a is invalid. Received: " + tag);
        }
        case  LAYOUT_HEADERLAYOUT: {
          if ("layout/header_layout_0".equals(tag)) {
            return new HeaderLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for header_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ODERBOTTOMSHEET: {
          if ("layout/oder_bottom_sheet_0".equals(tag)) {
            return new OderBottomSheetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for oder_bottom_sheet is invalid. Received: " + tag);
        }
        case  LAYOUT_ODERHISTOTOYCARDVIEW: {
          if ("layout/oder_histotoy_cardview_0".equals(tag)) {
            return new OderHistotoyCardviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for oder_histotoy_cardview is invalid. Received: " + tag);
        }
        case  LAYOUT_QNACARDVIEW: {
          if ("layout/q_n_a_card_view_0".equals(tag)) {
            return new QNACardViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for q_n_a_card_view is invalid. Received: " + tag);
        }
        case  LAYOUT_RESTAURANTMENUCARDVIEW: {
          if ("layout/restaurant_menu_cardview_0".equals(tag)) {
            return new RestaurantMenuCardviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for restaurant_menu_cardview is invalid. Received: " + tag);
        }
        case  LAYOUT_RESTAURANTSHOMECARDVIEW: {
          if ("layout/restaurants_home_cardview_0".equals(tag)) {
            return new RestaurantsHomeCardviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for restaurants_home_cardview is invalid. Received: " + tag);
        }
        case  LAYOUT_SIGNUPFRAGMENT: {
          if ("layout/sign_up_fragment_0".equals(tag)) {
            return new SignUpFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for sign_up_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(13);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "data");
      sKeys.put(2, "dataX");
      sKeys.put(3, "foodItem");
      sKeys.put(4, "menu");
      sKeys.put(5, "menuData");
      sKeys.put(6, "onFavoriteButtonClicked");
      sKeys.put(7, "onMenuButtonClicked");
      sKeys.put(8, "onOderButtonClicked");
      sKeys.put(9, "onRestaurantClicked");
      sKeys.put(10, "position");
      sKeys.put(11, "sno");
      sKeys.put(12, "view");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(10);

    static {
      sKeys.put("layout/cart_adapter_layout_0", com.sorabh.grabfood.R.layout.cart_adapter_layout);
      sKeys.put("layout/food_item_card_view_0", com.sorabh.grabfood.R.layout.food_item_card_view);
      sKeys.put("layout/fragment_q_n_a_0", com.sorabh.grabfood.R.layout.fragment_q_n_a);
      sKeys.put("layout/header_layout_0", com.sorabh.grabfood.R.layout.header_layout);
      sKeys.put("layout/oder_bottom_sheet_0", com.sorabh.grabfood.R.layout.oder_bottom_sheet);
      sKeys.put("layout/oder_histotoy_cardview_0", com.sorabh.grabfood.R.layout.oder_histotoy_cardview);
      sKeys.put("layout/q_n_a_card_view_0", com.sorabh.grabfood.R.layout.q_n_a_card_view);
      sKeys.put("layout/restaurant_menu_cardview_0", com.sorabh.grabfood.R.layout.restaurant_menu_cardview);
      sKeys.put("layout/restaurants_home_cardview_0", com.sorabh.grabfood.R.layout.restaurants_home_cardview);
      sKeys.put("layout/sign_up_fragment_0", com.sorabh.grabfood.R.layout.sign_up_fragment);
    }
  }
}
