package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.model.post.LoginPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetLoginResponseUseCase @Inject constructor(private val networkRepository: NetworkRepository):BaseUsaCase<LoginPostModel,LoginResponse>() {
    override suspend fun getData(params: LoginPostModel?): Result<LoginResponse> = networkRepository.getLoginDetails(params!!.header,
        params.params)
}