package com.sorabh.grabfood.domain.usecase

import com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu
import com.sorabh.grabfood.domain.repository.NetworkRepository
import javax.inject.Inject

class GetRestaurantMenuUseCase @Inject constructor(private val networkRepository: NetworkRepository):BaseUsaCase<RestaurantMenuPostModel,RestaurantMenu>() {
    override suspend fun getData(params: RestaurantMenuPostModel?) =
        networkRepository.getMenuList(params!!.header,params.restaurant_id)
}