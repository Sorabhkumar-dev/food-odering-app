package com.sorabh.grabfood;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sorabh.grabfood.domain.database.LocalDAO;
import com.sorabh.grabfood.domain.database.RestaurantDatabase;
import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.datastore.PreferenceDataImpl;
import com.sorabh.grabfood.domain.di.AppModule;
import com.sorabh.grabfood.domain.di.AppModule_ProvideContextFactory;
import com.sorabh.grabfood.domain.di.AppModule_ProvideDaoFactory;
import com.sorabh.grabfood.domain.di.AppModule_ProvideDataStoreFactory;
import com.sorabh.grabfood.domain.di.AppModule_ProvideNetworkInterfaceFactory;
import com.sorabh.grabfood.domain.di.AppModule_ProvideNetworkRepositoryFactory;
import com.sorabh.grabfood.domain.di.AppModule_ProvideRestaurantDbFactory;
import com.sorabh.grabfood.domain.di.AppModule_ProvidesUserOkHttpClientFactory;
import com.sorabh.grabfood.domain.network_api.NetworkInterface;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl;
import com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase;
import com.sorabh.grabfood.domain.usecase.GetLoginResponseUseCase;
import com.sorabh.grabfood.domain.usecase.GetOTPUseCase;
import com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase;
import com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase;
import com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase;
import com.sorabh.grabfood.domain.usecase.GetRestaurantUseCase;
import com.sorabh.grabfood.domain.usecase.GetSignupUseCase;
import com.sorabh.grabfood.ui.activities.ForgotPasswordFragment;
import com.sorabh.grabfood.ui.activities.LoginFragment;
import com.sorabh.grabfood.ui.activities.LoginFragment_MembersInjector;
import com.sorabh.grabfood.ui.activities.MainFragment;
import com.sorabh.grabfood.ui.activities.OTPFragment;
import com.sorabh.grabfood.ui.activities.OTPFragment_MembersInjector;
import com.sorabh.grabfood.ui.activities.RootActivity;
import com.sorabh.grabfood.ui.activities.SignUpFragment;
import com.sorabh.grabfood.ui.activities.SignUpFragment_MembersInjector;
import com.sorabh.grabfood.ui.activities.SplashFragment;
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter;
import com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter;
import com.sorabh.grabfood.ui.fragments.cart.CartFragment;
import com.sorabh.grabfood.ui.fragments.favorites.FavoriteRestaurantsFragment;
import com.sorabh.grabfood.ui.fragments.history.OderHistoryFragment;
import com.sorabh.grabfood.ui.fragments.home.HomeFragment;
import com.sorabh.grabfood.ui.fragments.home.HomeFragment_MembersInjector;
import com.sorabh.grabfood.ui.fragments.profile.MyProfileFragment;
import com.sorabh.grabfood.ui.fragments.qna.QNAFragment;
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment;
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment_MembersInjector;
import com.sorabh.grabfood.ui.viewmodel.CartViewModel;
import com.sorabh.grabfood.ui.viewmodel.CartViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel;
import com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel;
import com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel;
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.LoginViewModel;
import com.sorabh.grabfood.ui.viewmodel.LoginViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.MainViewModel;
import com.sorabh.grabfood.ui.viewmodel.MainViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel;
import com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel;
import com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.OtpViewModel;
import com.sorabh.grabfood.ui.viewmodel.OtpViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.QNAViewModel;
import com.sorabh.grabfood.ui.viewmodel.QNAViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel;
import com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.SignUpViewModel;
import com.sorabh.grabfood.ui.viewmodel.SignUpViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sorabh.grabfood.ui.viewmodel.SplashViewModel;
import com.sorabh.grabfood.ui.viewmodel.SplashViewModel_HiltModules_KeyModule_ProvideFactory;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerGrabFoodApplication_HiltComponents_SingletonC {
  private DaggerGrabFoodApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private AppModule appModule;

    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    public GrabFoodApplication_HiltComponents.SingletonC build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(appModule, applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements GrabFoodApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public GrabFoodApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements GrabFoodApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public GrabFoodApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements GrabFoodApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public GrabFoodApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements GrabFoodApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public GrabFoodApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements GrabFoodApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public GrabFoodApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements GrabFoodApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public GrabFoodApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements GrabFoodApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public GrabFoodApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends GrabFoodApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends GrabFoodApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectForgotPasswordFragment(ForgotPasswordFragment forgotPasswordFragment) {
    }

    @Override
    public void injectLoginFragment(LoginFragment loginFragment) {
      injectLoginFragment2(loginFragment);
    }

    @Override
    public void injectMainFragment(MainFragment mainFragment) {
    }

    @Override
    public void injectOTPFragment(OTPFragment oTPFragment) {
      injectOTPFragment2(oTPFragment);
    }

    @Override
    public void injectSignUpFragment(SignUpFragment signUpFragment) {
      injectSignUpFragment2(signUpFragment);
    }

    @Override
    public void injectSplashFragment(SplashFragment splashFragment) {
    }

    @Override
    public void injectCartFragment(CartFragment cartFragment) {
    }

    @Override
    public void injectFavoriteRestaurantsFragment(
        FavoriteRestaurantsFragment favoriteRestaurantsFragment) {
    }

    @Override
    public void injectOderHistoryFragment(OderHistoryFragment oderHistoryFragment) {
    }

    @Override
    public void injectHomeFragment(HomeFragment homeFragment) {
      injectHomeFragment2(homeFragment);
    }

    @Override
    public void injectMyProfileFragment(MyProfileFragment myProfileFragment) {
    }

    @Override
    public void injectQNAFragment(QNAFragment qNAFragment) {
    }

    @Override
    public void injectRestaurantMenuFragment(RestaurantMenuFragment restaurantMenuFragment) {
      injectRestaurantMenuFragment2(restaurantMenuFragment);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }

    private LoginFragment injectLoginFragment2(LoginFragment instance) {
      LoginFragment_MembersInjector.injectRepository(instance, singletonCImpl.networkRepository());
      return instance;
    }

    private OTPFragment injectOTPFragment2(OTPFragment instance) {
      OTPFragment_MembersInjector.injectRepository(instance, singletonCImpl.networkRepository());
      return instance;
    }

    private SignUpFragment injectSignUpFragment2(SignUpFragment instance) {
      SignUpFragment_MembersInjector.injectRepository(instance, singletonCImpl.networkRepository());
      return instance;
    }

    private HomeFragment injectHomeFragment2(HomeFragment instance) {
      HomeFragment_MembersInjector.injectRestaurantHomeAdapter(instance, new RestaurantHomeAdapter());
      return instance;
    }

    private RestaurantMenuFragment injectRestaurantMenuFragment2(RestaurantMenuFragment instance) {
      RestaurantMenuFragment_MembersInjector.injectRestaurantMenuAdapter(instance, new RestaurantMenuAdapter());
      return instance;
    }
  }

  private static final class ViewCImpl extends GrabFoodApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends GrabFoodApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectRootActivity(RootActivity rootActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(13).add(CartViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(FavoriteRestaurantsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(HomeViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(LoginViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(MainViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(MyProfileViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(OderHistoryVieModel_HiltModules_KeyModule_ProvideFactory.provide()).add(OtpViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(QNAViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RestaurantMenuViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(SignUpViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(SplashViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends GrabFoodApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<CartViewModel> cartViewModelProvider;

    private Provider<FavoriteRestaurantsViewModel> favoriteRestaurantsViewModelProvider;

    private Provider<ForgotPasswordViewModel> forgotPasswordViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<MainViewModel> mainViewModelProvider;

    private Provider<MyProfileViewModel> myProfileViewModelProvider;

    private Provider<OderHistoryVieModel> oderHistoryVieModelProvider;

    private Provider<OtpViewModel> otpViewModelProvider;

    private Provider<QNAViewModel> qNAViewModelProvider;

    private Provider<RestaurantMenuViewModel> restaurantMenuViewModelProvider;

    private Provider<SignUpViewModel> signUpViewModelProvider;

    private Provider<SplashViewModel> splashViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    private GetOderConfirmationUseCase getOderConfirmationUseCase() {
      return new GetOderConfirmationUseCase(singletonCImpl.networkRepository());
    }

    private LocalDBRepository localDBRepository() {
      return new LocalDBRepository(singletonCImpl.localDAO());
    }

    private GetForgotPasswordUseCase getForgotPasswordUseCase() {
      return new GetForgotPasswordUseCase(singletonCImpl.networkRepository());
    }

    private GetRestaurantUseCase getRestaurantUseCase() {
      return new GetRestaurantUseCase(singletonCImpl.networkRepository());
    }

    private GetLoginResponseUseCase getLoginResponseUseCase() {
      return new GetLoginResponseUseCase(singletonCImpl.networkRepository());
    }

    private GetOderHistoryUseCase getOderHistoryUseCase() {
      return new GetOderHistoryUseCase(singletonCImpl.networkRepository());
    }

    private GetOTPUseCase getOTPUseCase() {
      return new GetOTPUseCase(singletonCImpl.networkRepository());
    }

    private GetRestaurantMenuUseCase getRestaurantMenuUseCase() {
      return new GetRestaurantMenuUseCase(singletonCImpl.networkRepository());
    }

    private GetSignupUseCase getSignupUseCase() {
      return new GetSignupUseCase(singletonCImpl.networkRepository());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.cartViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.favoriteRestaurantsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.forgotPasswordViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.myProfileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.oderHistoryVieModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.otpViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.qNAViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.restaurantMenuViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
      this.signUpViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11);
      this.splashViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, Provider<ViewModel>>newMapBuilder(13).put("com.sorabh.grabfood.ui.viewmodel.CartViewModel", ((Provider) cartViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel", ((Provider) favoriteRestaurantsViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel", ((Provider) forgotPasswordViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.HomeViewModel", ((Provider) homeViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.LoginViewModel", ((Provider) loginViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.MainViewModel", ((Provider) mainViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel", ((Provider) myProfileViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel", ((Provider) oderHistoryVieModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.OtpViewModel", ((Provider) otpViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.QNAViewModel", ((Provider) qNAViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel", ((Provider) restaurantMenuViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.SignUpViewModel", ((Provider) signUpViewModelProvider)).put("com.sorabh.grabfood.ui.viewmodel.SplashViewModel", ((Provider) splashViewModelProvider)).build();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.sorabh.grabfood.ui.viewmodel.CartViewModel 
          return (T) new CartViewModel(viewModelCImpl.getOderConfirmationUseCase(), viewModelCImpl.localDBRepository(), singletonCImpl.provideDataStoreProvider.get());

          case 1: // com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel 
          return (T) new FavoriteRestaurantsViewModel(viewModelCImpl.localDBRepository());

          case 2: // com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel 
          return (T) new ForgotPasswordViewModel(viewModelCImpl.getForgotPasswordUseCase());

          case 3: // com.sorabh.grabfood.ui.viewmodel.HomeViewModel 
          return (T) new HomeViewModel(viewModelCImpl.getRestaurantUseCase(), viewModelCImpl.localDBRepository());

          case 4: // com.sorabh.grabfood.ui.viewmodel.LoginViewModel 
          return (T) new LoginViewModel(viewModelCImpl.getLoginResponseUseCase(), singletonCImpl.provideDataStoreProvider.get());

          case 5: // com.sorabh.grabfood.ui.viewmodel.MainViewModel 
          return (T) new MainViewModel(singletonCImpl.provideDataStoreProvider.get());

          case 6: // com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel 
          return (T) new MyProfileViewModel(singletonCImpl.provideDataStoreProvider.get());

          case 7: // com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel 
          return (T) new OderHistoryVieModel(viewModelCImpl.getOderHistoryUseCase(), singletonCImpl.provideDataStoreProvider.get());

          case 8: // com.sorabh.grabfood.ui.viewmodel.OtpViewModel 
          return (T) new OtpViewModel(viewModelCImpl.getOTPUseCase());

          case 9: // com.sorabh.grabfood.ui.viewmodel.QNAViewModel 
          return (T) new QNAViewModel(viewModelCImpl.localDBRepository());

          case 10: // com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel 
          return (T) new RestaurantMenuViewModel(viewModelCImpl.getRestaurantMenuUseCase(), viewModelCImpl.localDBRepository());

          case 11: // com.sorabh.grabfood.ui.viewmodel.SignUpViewModel 
          return (T) new SignUpViewModel(viewModelCImpl.getSignupUseCase());

          case 12: // com.sorabh.grabfood.ui.viewmodel.SplashViewModel 
          return (T) new SplashViewModel(singletonCImpl.provideDataStoreProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends GrabFoodApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends GrabFoodApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends GrabFoodApplication_HiltComponents.SingletonC {
    private final AppModule appModule;

    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<OkHttpClient> providesUserOkHttpClientProvider;

    private Provider<PreferenceData> provideDataStoreProvider;

    private SingletonCImpl(AppModule appModuleParam,
        ApplicationContextModule applicationContextModuleParam) {
      this.appModule = appModuleParam;
      this.applicationContextModule = applicationContextModuleParam;
      initialize(appModuleParam, applicationContextModuleParam);

    }

    private NetworkInterface networkInterface() {
      return AppModule_ProvideNetworkInterfaceFactory.provideNetworkInterface(appModule, providesUserOkHttpClientProvider.get());
    }

    private NetworkRepositoryImpl networkRepositoryImpl() {
      return new NetworkRepositoryImpl(networkInterface());
    }

    private NetworkRepository networkRepository() {
      return AppModule_ProvideNetworkRepositoryFactory.provideNetworkRepository(appModule, networkRepositoryImpl());
    }

    private Context context() {
      return AppModule_ProvideContextFactory.provideContext(appModule, ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    private RestaurantDatabase restaurantDatabase() {
      return AppModule_ProvideRestaurantDbFactory.provideRestaurantDb(appModule, context());
    }

    private LocalDAO localDAO() {
      return AppModule_ProvideDaoFactory.provideDao(appModule, restaurantDatabase());
    }

    private PreferenceDataImpl preferenceDataImpl() {
      return new PreferenceDataImpl(context());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final AppModule appModuleParam,
        final ApplicationContextModule applicationContextModuleParam) {
      this.providesUserOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 0));
      this.provideDataStoreProvider = DoubleCheck.provider(new SwitchingProvider<PreferenceData>(singletonCImpl, 1));
    }

    @Override
    public void injectGrabFoodApplication(GrabFoodApplication grabFoodApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // okhttp3.OkHttpClient 
          return (T) AppModule_ProvidesUserOkHttpClientFactory.providesUserOkHttpClient(singletonCImpl.appModule);

          case 1: // com.sorabh.grabfood.domain.datastore.PreferenceData 
          return (T) AppModule_ProvideDataStoreFactory.provideDataStore(singletonCImpl.appModule, singletonCImpl.preferenceDataImpl());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
