package com.sorabh.grabfood.util

import androidx.recyclerview.widget.DiffUtil
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX

class CartDiffUtil(private val oldList: List<DataX>, private val newList: List<DataX>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].cost_for_one == newList[newItemPosition].cost_for_one &&
                oldList[oldItemPosition].id == newList[newItemPosition].id &&
                oldList[oldItemPosition].restaurant_id == newList[newItemPosition].restaurant_id &&
                oldList[oldItemPosition].name == newList[newItemPosition].name
                )
    }
}