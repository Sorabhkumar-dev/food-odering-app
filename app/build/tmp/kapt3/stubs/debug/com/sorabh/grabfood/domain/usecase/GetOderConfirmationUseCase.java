package com.sorabh.grabfood.domain.usecase;

import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation;
import com.sorabh.grabfood.domain.model.post.OderPostModel;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/sorabh/grabfood/domain/usecase/GetOderConfirmationUseCase;", "Lcom/sorabh/grabfood/domain/usecase/BaseUsaCase;", "Lcom/sorabh/grabfood/domain/model/post/OderPostModel;", "Lcom/sorabh/grabfood/domain/model/oder_respones/OderConfirmation;", "networkRepository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "getData", "Lcom/sorabh/grabfood/domain/network_api/Result;", "params", "(Lcom/sorabh/grabfood/domain/model/post/OderPostModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetOderConfirmationUseCase extends com.sorabh.grabfood.domain.usecase.BaseUsaCase<com.sorabh.grabfood.domain.model.post.OderPostModel, com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation> {
    private final com.sorabh.grabfood.domain.repository.NetworkRepository networkRepository = null;
    
    @javax.inject.Inject()
    public GetOderConfirmationUseCase(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.NetworkRepository networkRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getData(@org.jetbrains.annotations.Nullable()
    com.sorabh.grabfood.domain.model.post.OderPostModel params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation>> continuation) {
        return null;
    }
}