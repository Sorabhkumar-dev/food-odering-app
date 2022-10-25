package com.sorabh.grabfood.domain.network_api

sealed class Result<T>{
    class Loading<T> : Result<T>()
    class Error<T>(val code:Int,val message:String): Result<T>()
    class Success<T>(val body:T?,val code:Int,val message: String): Result<T>()
}
