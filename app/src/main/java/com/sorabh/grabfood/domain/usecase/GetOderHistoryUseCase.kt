package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory
import com.sorabh.grabfood.domain.model.post.OderHistoryPost
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetOderHistoryUseCase @Inject constructor(private val networkRepository: NetworkRepository) :BaseUsaCase<OderHistoryPost,OderHistory>() {
    override suspend fun getData(params: OderHistoryPost?) =
        networkRepository.getOderHistory(params!!.header,params.user_id)
}