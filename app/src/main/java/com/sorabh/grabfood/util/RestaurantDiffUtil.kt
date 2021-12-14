package com.sorabh.grabfood.util

import androidx.recyclerview.widget.DiffUtil
import com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX

class RestaurantDiffUtil(private val newList: List<DataX>?, private val oldList: List<DataX>?) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList?.size!!

    override fun getNewListSize(): Int = newList?.size!!

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList?.get(newItemPosition)?.name == oldList?.get(oldItemPosition)?.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList?.get(oldItemPosition)?.cost_for_one == newList?.get(newItemPosition)?.cost_for_one &&
                oldList?.get(oldItemPosition)?.image_url == newList?.get(newItemPosition)?.image_url &&
                oldList?.get(oldItemPosition)?.rating == newList?.get(newItemPosition)?.rating &&
                oldList?.get(oldItemPosition)?.id == newList?.get(newItemPosition)?.id
                )
    }
}