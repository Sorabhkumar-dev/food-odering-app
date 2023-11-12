package com.sorabh.grabfood.domain.usecase;

import com.sorabh.grabfood.domain.model.login_respones.LoginResponse;
import com.sorabh.grabfood.domain.model.post.LoginPostModel;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/sorabh/grabfood/domain/usecase/GetLoginResponseUseCase;", "Lcom/sorabh/grabfood/domain/usecase/BaseUsaCase;", "Lcom/sorabh/grabfood/domain/model/post/LoginPostModel;", "Lcom/sorabh/grabfood/domain/model/login_respones/LoginResponse;", "networkRepository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "getData", "Lcom/sorabh/grabfood/domain/network_api/Result;", "params", "(Lcom/sorabh/grabfood/domain/model/post/LoginPostModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetLoginResponseUseCase extends com.sorabh.grabfood.domain.usecase.BaseUsaCase<com.sorabh.grabfood.domain.model.post.LoginPostModel, com.sorabh.grabfood.domain.model.login_respones.LoginResponse> {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.repository.NetworkRepository networkRepository = null;
    
    @javax.inject.Inject
    public GetLoginResponseUseCase(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.repository.NetworkRepository networkRepository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getData(@org.jetbrains.annotations.Nullable
    com.sorabh.grabfood.domain.model.post.LoginPostModel params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.login_respones.LoginResponse>> $completion) {
        return null;
    }
}