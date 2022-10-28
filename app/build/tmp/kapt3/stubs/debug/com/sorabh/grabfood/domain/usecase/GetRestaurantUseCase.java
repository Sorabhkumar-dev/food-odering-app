package com.sorabh.grabfood.domain.usecase;

import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0004\u0012\u00020\u00050\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ?\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/sorabh/grabfood/domain/usecase/GetRestaurantUseCase;", "Lcom/sorabh/grabfood/domain/usecase/BaseUsaCase;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Restaurant;", "networkRepository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "getData", "Lcom/sorabh/grabfood/domain/network_api/Result;", "params", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetRestaurantUseCase extends com.sorabh.grabfood.domain.usecase.BaseUsaCase<java.util.HashMap<java.lang.String, java.lang.String>, com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant> {
    private final com.sorabh.grabfood.domain.repository.NetworkRepository networkRepository = null;
    
    @javax.inject.Inject()
    public GetRestaurantUseCase(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.NetworkRepository networkRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getData(@org.jetbrains.annotations.Nullable()
    java.util.HashMap<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant>> continuation) {
        return null;
    }
}