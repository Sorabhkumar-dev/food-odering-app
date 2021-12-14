package com.sorabh.grabfood.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.api_response_classes.oder_history_response.DataX
import com.sorabh.grabfood.databinding.OderHistotoyCardviewBinding

class OrderHistoryAdapter(val context: Context) : RecyclerView.Adapter<OrderHistoryViewHolder>() {
    private var oderHistoryList = ArrayList<DataX>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryViewHolder =
        OrderHistoryViewHolder.form(parent)

    override fun onBindViewHolder(holder: OrderHistoryViewHolder, position: Int) =
        holder.bind(oderHistoryList[position], context)

    override fun getItemCount(): Int = oderHistoryList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateOderHistoryList(list: List<DataX>) {
        oderHistoryList.clear()
        oderHistoryList = list as ArrayList<DataX>
        notifyDataSetChanged()
    }
}

class OrderHistoryViewHolder(private val oderHistoryCardViewBinding: OderHistotoyCardviewBinding) :
    RecyclerView.ViewHolder(oderHistoryCardViewBinding.root) {
    fun bind(currentData: DataX, context: Context) {
        val foodItemAdapter = FoodItemAdapter()
        val layout = LinearLayoutManager(context)
        with(oderHistoryCardViewBinding.orderHistoryRecyclerView){
            layoutManager = layout
            adapter = foodItemAdapter
        }
        foodItemAdapter.updateFoodItem(currentData.food_items)
        oderHistoryCardViewBinding.dataX = currentData
        oderHistoryCardViewBinding.executePendingBindings()
    }

    companion object {
        fun form(parent: ViewGroup): OrderHistoryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val oderHistoryCardViewBinding = DataBindingUtil.inflate<OderHistotoyCardviewBinding>(
                layoutInflater,
                R.layout.oder_histotoy_cardview, parent, false
            )

            return OrderHistoryViewHolder(oderHistoryCardViewBinding)
        }
    }
}