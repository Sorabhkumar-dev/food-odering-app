package com.sorabh.grabfood.domain.usecase

import kotlinx.coroutines.flow.Flow
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.util.Constants
import kotlinx.coroutines.flow.flow

abstract class BaseUsaCase<P,R> {
    private fun getResponse(params:P?):Flow<Result<R>> = flow {
        emit(Result.Loading())
        try {
            emit(getData(params))
        }catch (e:Exception){
            emit(Result.Error(500,e.message ?: Constants.NETWORK_ERROR))
        }
    }

    abstract suspend fun getData(params: P?):Result<R>

    operator fun invoke(params: P) = getResponse(params)

    operator fun invoke() = getResponse(null)

}