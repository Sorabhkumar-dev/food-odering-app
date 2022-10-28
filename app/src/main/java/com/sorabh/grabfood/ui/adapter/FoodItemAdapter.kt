package com.sorabh.grabfood.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem
import com.sorabh.grabfood.databinding.FoodItemCardViewBinding
import javax.inject.Inject

class FoodItemAdapter @Inject constructor() : RecyclerView.Adapter<FoodItemViewHolder>() {
    private var foodItemList:MutableList<FoodItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FoodItemViewHolder(FoodItemCardViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        holder.foodItemCardViewBinding.foodItem = foodItemList[position]
        holder.foodItemCardViewBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = foodItemList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateFoodItem(newFoodItem: List<FoodItem>){
        foodItemList.clear()
        foodItemList.addAll(newFoodItem)
        notifyDataSetChanged()
    }
}

class FoodItemViewHolder(val foodItemCardViewBinding: FoodItemCardViewBinding) :
    RecyclerView.ViewHolder(foodItemCardViewBinding.root)
