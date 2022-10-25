package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetRestaurantUseCase @Inject constructor(private val networkRepository: NetworkRepository):BaseUsaCase<HashMap<String,String>,Restaurant>() {
    override suspend fun getData(params: HashMap<String, String>?) = networkRepository.getRestaurantsList(params!!)
}