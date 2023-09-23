package com.sorabh.grabfood.ui.fragments.restaurant_menu;

import com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RestaurantMenuFragment_MembersInjector implements MembersInjector<RestaurantMenuFragment> {
  private final Provider<RestaurantMenuAdapter> restaurantMenuAdapterProvider;

  public RestaurantMenuFragment_MembersInjector(
      Provider<RestaurantMenuAdapter> restaurantMenuAdapterProvider) {
    this.restaurantMenuAdapterProvider = restaurantMenuAdapterProvider;
  }

  public static MembersInjector<RestaurantMenuFragment> create(
      Provider<RestaurantMenuAdapter> restaurantMenuAdapterProvider) {
    return new RestaurantMenuFragment_MembersInjector(restaurantMenuAdapterProvider);
  }

  @Override
  public void injectMembers(RestaurantMenuFragment instance) {
    injectRestaurantMenuAdapter(instance, restaurantMenuAdapterProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment.restaurantMenuAdapter")
  public static void injectRestaurantMenuAdapter(RestaurantMenuFragment instance,
      RestaurantMenuAdapter restaurantMenuAdapter) {
    instance.restaurantMenuAdapter = restaurantMenuAdapter;
  }
}
