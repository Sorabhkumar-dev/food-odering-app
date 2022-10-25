package com.sorabh.grabfood.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.databinding.CartAdapterLayoutBinding
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import javax.inject.Inject

class CartAdapter @Inject constructor() : RecyclerView.Adapter<CartViewHolder>() {
    private var menuList: MutableList<Menu> = mutableListOf()

    var onOderButtonClickedListener: CartViewHolder.OnOderButtonClickedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CartViewHolder(
            CartAdapterLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.cartAdapterLayoutBinding.menu = menuList[position]
        holder.cartAdapterLayoutBinding.position = (position + 1).toString()
        holder.cartAdapterLayoutBinding.onOderButtonClicked = onOderButtonClickedListener
        holder.cartAdapterLayoutBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = menuList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateMenuList(newMenuList: List<Menu>?) {
        newMenuList?.let {
            menuList.clear()
            menuList.addAll(it)
            notifyDataSetChanged()
        }
    }
}

class CartViewHolder(val cartAdapterLayoutBinding: CartAdapterLayoutBinding) :
    RecyclerView.ViewHolder(cartAdapterLayoutBinding.root) {
    interface OnOderButtonClickedListener {
        fun onOderButtonClicked(menu: Menu)
    }
}