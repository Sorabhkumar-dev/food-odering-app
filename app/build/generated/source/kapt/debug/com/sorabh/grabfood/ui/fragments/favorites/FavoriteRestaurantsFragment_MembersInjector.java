package com.sorabh.grabfood.ui.fragments.favorites;

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
public final class FavoriteRestaurantsFragment_MembersInjector implements MembersInjector<FavoriteRestaurantsFragment> {
  private final Provider<RestaurantHomeAdapter> restaurantHomeAdapterProvider;

  public FavoriteRestaurantsFragment_MembersInjector(
      Provider<RestaurantHomeAdapter> restaurantHomeAdapterProvider) {
    this.restaurantHomeAdapterProvider = restaurantHomeAdapterProvider;
  }

  public static MembersInjector<FavoriteRestaurantsFragment> create(
      Provider<RestaurantHomeAdapter> restaurantHomeAdapterProvider) {
    return new FavoriteRestaurantsFragment_MembersInjector(restaurantHomeAdapterProvider);
  }

  @Override
  public void injectMembers(FavoriteRestaurantsFragment instance) {
    injectRestaurantHomeAdapter(instance, restaurantHomeAdapterProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.favorites.FavoriteRestaurantsFragment.restaurantHomeAdapter")
  public static void injectRestaurantHomeAdapter(FavoriteRestaurantsFragment instance,
      RestaurantHomeAdapter restaurantHomeAdapter) {
    instance.restaurantHomeAdapter = restaurantHomeAdapter;
  }
}
