package com.sorabh.grabfood.ui.fragments.cart;

import com.sorabh.grabfood.ui.adapter.CartAdapter;
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
public final class CartFragment_MembersInjector implements MembersInjector<CartFragment> {
  private final Provider<CartAdapter> cartAdapterProvider;

  public CartFragment_MembersInjector(Provider<CartAdapter> cartAdapterProvider) {
    this.cartAdapterProvider = cartAdapterProvider;
  }

  public static MembersInjector<CartFragment> create(Provider<CartAdapter> cartAdapterProvider) {
    return new CartFragment_MembersInjector(cartAdapterProvider);
  }

  @Override
  public void injectMembers(CartFragment instance) {
    injectCartAdapter(instance, cartAdapterProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.cart.CartFragment.cartAdapter")
  public static void injectCartAdapter(CartFragment instance, CartAdapter cartAdapter) {
    instance.cartAdapter = cartAdapter;
  }
}
