package com.sorabh.grabfood.api_response_classes.reataurants_home_response

import com.sorabh.grabfood.domain.model.reataurants_home_response.DataX

data class Data(
    val `data`: List<DataX>,
    val success: Boolean
)