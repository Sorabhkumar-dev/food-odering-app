package com.sorabh.grabfood.domain.usecase;

import kotlinx.coroutines.flow.Flow;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.util.Constants;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\n2\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\nH\u0086\u0002J\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\n2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/sorabh/grabfood/domain/usecase/BaseUsaCase;", "P", "R", "", "()V", "getData", "Lcom/sorabh/grabfood/domain/network_api/Result;", "params", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResponse", "Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "invoke", "app_debug"})
public abstract class BaseUsaCase<P extends java.lang.Object, R extends java.lang.Object> {
    
    public BaseUsaCase() {
        super();
    }
    
    private final kotlinx.coroutines.flow.Flow<com.sorabh.grabfood.domain.network_api.Result<R>> getResponse(P params) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getData(@org.jetbrains.annotations.Nullable
    P params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<R>> $completion);
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.sorabh.grabfood.domain.network_api.Result<R>> invoke(P params) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.sorabh.grabfood.domain.network_api.Result<R>> invoke() {
        return null;
    }
}