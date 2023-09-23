package com.sorabh.grabfood.ui.fragments.home;

import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter;
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
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<RestaurantHomeAdapter> restaurantHomeAdapterProvider;

  public HomeFragment_MembersInjector(
      Provider<RestaurantHomeAdapter> restaurantHomeAdapterProvider) {
    this.restaurantHomeAdapterProvider = restaurantHomeAdapterProvider;
  }

  public static MembersInjector<HomeFragment> create(
      Provider<RestaurantHomeAdapter> restaurantHomeAdapterProvider) {
    return new HomeFragment_MembersInjector(restaurantHomeAdapterProvider);
  }

  @Override
  public void injectMembers(HomeFragment instance) {
    injectRestaurantHomeAdapter(instance, restaurantHomeAdapterProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.home.HomeFragment.restaurantHomeAdapter")
  public static void injectRestaurantHomeAdapter(HomeFragment instance,
      RestaurantHomeAdapter restaurantHomeAdapter) {
    instance.restaurantHomeAdapter = restaurantHomeAdapter;
  }
}
