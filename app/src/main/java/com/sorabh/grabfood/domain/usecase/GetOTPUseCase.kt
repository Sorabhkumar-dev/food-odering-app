package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetOTPUseCase @Inject constructor(private val networkRepository: NetworkRepository) :
    BaseUsaCase<OderPostModel, OTPResponse>() {
    override suspend fun getData(params: OderPostModel?) = networkRepository.getOTPResponse(params!!.header,params.params)
}