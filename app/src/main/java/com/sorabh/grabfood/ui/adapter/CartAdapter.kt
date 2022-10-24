package com.sorabh.grabfood.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.databinding.CartAdapterLayoutBinding
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class CartAdapter @Inject constructor(private val localDBRepository: LocalDBRepository) : RecyclerView.Adapter<CartViewHolder>() {
    private var menuList = ArrayList<DataX>()

    var onOderButtonClickedListener: CartViewHolder.OnOderButtonClickedListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cartAdapterLayoutBinding = DataBindingUtil.inflate<CartAdapterLayoutBinding>(
            layoutInflater,
            R.layout.cart_adapter_layout, parent, false
        )
        return CartViewHolder(cartAdapterLayoutBinding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.cartAdapterLayoutBinding.menu = menuList[position]
        holder.cartAdapterLayoutBinding.position = (position + 1).toString()
        holder.cartAdapterLayoutBinding.onOderButtonClicked = onOderButtonClickedListener
        holder.cartAdapterLayoutBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = menuList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateMenuList(newMenuList: List<DataX>?) {
        menuList.clear()
        menuList = newMenuList as ArrayList<DataX>
        notifyDataSetChanged()
    }

    fun update() {
        val job = SupervisorJob()
        CoroutineScope(job + Dispatchers.IO).launch {
            val menuList: List<DataX>? = localDBRepository.getMenuList()
            withContext(Dispatchers.Main) {
                updateMenuList(menuList)
            }

        }
    }


}

class CartViewHolder(val cartAdapterLayoutBinding: CartAdapterLayoutBinding) :
    RecyclerView.ViewHolder(cartAdapterLayoutBinding.root) {
    interface OnOderButtonClickedListener {
        fun onOderButtonClicked(menu: DataX)
    }
}