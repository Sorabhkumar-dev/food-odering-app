package com.sorabh.grabfood.util

import androidx.recyclerview.widget.DiffUtil
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish

class RestaurantDiffUtil(private val newList: List<Dish>?, private val oldList: List<Dish>?) :
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