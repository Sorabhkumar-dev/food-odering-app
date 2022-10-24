package com.sorabh.grabfood.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem
import com.sorabh.grabfood.databinding.FoodItemCardViewBinding

class FoodItemAdapter : RecyclerView.Adapter<FoodItemViewHolder>() {
    private var foodItemList = ArrayList<FoodItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder =
        FoodItemViewHolder.form(parent)

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) =
        holder.bind(foodItemList[position])

    override fun getItemCount(): Int = foodItemList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateFoodItem(list: List<FoodItem>){
        foodItemList.clear()
        foodItemList = list as ArrayList<FoodItem>
        notifyDataSetChanged()
    }
}

class FoodItemViewHolder(private val foodItemCardViewBinding: FoodItemCardViewBinding) :
    RecyclerView.ViewHolder(foodItemCardViewBinding.root) {
    fun bind(currentFoodItem: FoodItem) {
        foodItemCardViewBinding.foodItem = currentFoodItem
        foodItemCardViewBinding.executePendingBindings()
    }

    companion object {
        fun form(parent: ViewGroup): FoodItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val foodItemCardViewBinding = DataBindingUtil.inflate<FoodItemCardViewBinding>(
                layoutInflater,
                R.layout.food_item_card_view,
                parent,
                false
            )
            return FoodItemViewHolder(foodItemCardViewBinding)
        }
    }
}
