package com.sorabh.grabfood.ui.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.databinding.OderHistotoyCardviewBinding
import com.sorabh.grabfood.domain.model.oder_history_response.Bill
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class OrderHistoryAdapter @Inject constructor(private val foodItemAdapter: FoodItemAdapter) : RecyclerView.Adapter<OrderHistoryViewHolder>() {
    private var oderHistoryList :MutableList<Bill> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        OrderHistoryViewHolder(OderHistotoyCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: OrderHistoryViewHolder, position: Int) {
        holder.oderHistoryCardViewBinding.orderHistoryRecyclerView.adapter = foodItemAdapter
        foodItemAdapter.updateFoodItem(oderHistoryList[position].food_items)
        holder.oderHistoryCardViewBinding.orderHistoryOderDate.text = getDate(oderHistoryList[position].order_placed_at)
        holder.oderHistoryCardViewBinding.dataX = oderHistoryList[position]
        holder.oderHistoryCardViewBinding.executePendingBindings()
    }


    override fun getItemCount(): Int = oderHistoryList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateOderHistoryList(list: List<Bill>) {
        oderHistoryList.clear()
        oderHistoryList.addAll(list)
        notifyDataSetChanged()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getDate(str:String):String{
        val sourceFormat = "dd-mm-yy HH:mm:ss"
        val parsedFormat = "HH:mm dd-MMM-YYYY"
        val date =  SimpleDateFormat(sourceFormat, Locale.getDefault()).parse(str) ?: Date()
      return  SimpleDateFormat(parsedFormat, Locale.getDefault()).format(date)
    }
}

class OrderHistoryViewHolder(val oderHistoryCardViewBinding: OderHistotoyCardviewBinding) :
    RecyclerView.ViewHolder(oderHistoryCardViewBinding.root)