package com.sorabh.grabfood.domain.network_api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/sorabh/grabfood/domain/network_api/Result;", "T", "", "()V", "Error", "Loading", "Success", "Lcom/sorabh/grabfood/domain/network_api/Result$Loading;", "Lcom/sorabh/grabfood/domain/network_api/Result$Error;", "Lcom/sorabh/grabfood/domain/network_api/Result$Success;", "app_debug"})
public abstract class Result<T extends java.lang.Object> {
    
    private Result() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/sorabh/grabfood/domain/network_api/Result$Loading;", "T", "Lcom/sorabh/grabfood/domain/network_api/Result;", "()V", "app_debug"})
    public static final class Loading<T extends java.lang.Object> extends com.sorabh.grabfood.domain.network_api.Result<T> {
        
        public Loading() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/sorabh/grabfood/domain/network_api/Result$Error;", "T", "Lcom/sorabh/grabfood/domain/network_api/Result;", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "app_debug"})
    public static final class Error<T extends java.lang.Object> extends com.sorabh.grabfood.domain.network_api.Result<T> {
        private final int code = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Error(int code, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
        
        public final int getCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/sorabh/grabfood/domain/network_api/Result$Success;", "T", "Lcom/sorabh/grabfood/domain/network_api/Result;", "body", "code", "", "message", "", "(Ljava/lang/Object;ILjava/lang/String;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends com.sorabh.grabfood.domain.network_api.Result<T> {
        @org.jetbrains.annotations.Nullable()
        private final T body = null;
        private final int code = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Success(@org.jetbrains.annotations.Nullable()
        T body, int code, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final T getBody() {
            return null;
        }
        
        public final int getCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
    }
}