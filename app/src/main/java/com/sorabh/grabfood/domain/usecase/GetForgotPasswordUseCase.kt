package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetForgotPasswordUseCase @Inject constructor(private val networkRepository: NetworkRepository) :
    BaseUsaCase<OderPostModel, ForgotResponse>() {
    override suspend fun getData(params: OderPostModel?) =
        networkRepository.getForgotResponse(params!!.header, params.params)
}