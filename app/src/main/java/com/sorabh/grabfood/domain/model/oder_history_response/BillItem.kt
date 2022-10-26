package com.sorabh.grabfood.domain.model.oder_history_response

data class BillItem(
    val `data`: List<Bill>,
    val success: Boolean
)