package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetOderConfirmationUseCase @Inject constructor(private val networkRepository: NetworkRepository) :
    BaseUsaCase<OderPostModel, OderConfirmation>() {
    override suspend fun getData(params: OderPostModel?) = networkRepository.placeOder(
        params!!.header,
        params.params
    )
}