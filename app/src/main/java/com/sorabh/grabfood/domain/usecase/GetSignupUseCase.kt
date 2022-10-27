package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetSignupUseCase @Inject constructor(private val networkRepository: NetworkRepository) :
    BaseUsaCase<OderPostModel, SignUpResponse>() {
    override suspend fun getData(params: OderPostModel?) =
        networkRepository.getSignUpDetails(params!!.header, params.params)
}