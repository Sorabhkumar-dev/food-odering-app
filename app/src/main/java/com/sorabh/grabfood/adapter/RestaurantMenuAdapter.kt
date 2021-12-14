package com.sorabh.grabfood.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding
import com.sorabh.grabfood.repository.LocalDBRepository
import com.sorabh.grabfood.repository.NetworkRepository
import kotlinx.coroutines.*

class RestaurantMenuAdapter(val context: Context) :
    RecyclerView.Adapter<RestaurantMenuViewHolder>(),
    RestaurantMenuViewHolder.OnMenuButtonClickedListener {

    private var restaurantMenuList = ArrayList<DataX>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantMenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val restaurantMenuCardViewBinding =
            DataBindingUtil.inflate<RestaurantMenuCardviewBinding>(
                layoutInflater,
                R.layout.restaurant_menu_cardview, parent, false
            )
        return RestaurantMenuViewHolder(restaurantMenuCardViewBinding)

    }

    override fun onBindViewHolder(holder: RestaurantMenuViewHolder, position: Int) {
        var menuData: DataX?
        val job = SupervisorJob()
        CoroutineScope(job + Dispatchers.IO).launch {
            val localDBRepository = LocalDBRepository(context)
            menuData = localDBRepository.getMenuItem(restaurantMenuList[position].id)
            if (menuData != null) {
                withContext(Dispatchers.Main) {
                    holder.restaurantMenuCardViewBinding.btnRestaurantMenuAdd.apply {
                        text = "Remove From cart"
                        setBackgroundColor(Color.RED)
                    }
                }
            }
        }
        holder.restaurantMenuCardViewBinding.menuData = restaurantMenuList[position]
        holder.restaurantMenuCardViewBinding.sno = "${position + 1}"
        holder.restaurantMenuCardViewBinding.onMenuButtonClicked = this
        holder.restaurantMenuCardViewBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = restaurantMenuList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateRestaurantMenu(list: List<DataX>?) {
        restaurantMenuList.clear()
        restaurantMenuList = list as ArrayList<DataX>
        notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n")
    override fun onMenuButtonClicked(dataX: DataX) {
        val job = SupervisorJob()
        CoroutineScope(job + Dispatchers.IO).launch {
            //header to send
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json"
            header["token"] = "025c40375fadfd"

            val localDBRepository = LocalDBRepository(context)
            val networkRepository = NetworkRepository()

            val data = localDBRepository.getMenuItem(dataX.id)

            var menuList: List<DataX>?
            if (data != null) {
                localDBRepository.deleteMenu(dataX)
                try {
                    menuList =
                        networkRepository.getMenuList(header, dataX.restaurant_id)
                    withContext(Dispatchers.Main) {
                        updateRestaurantMenu(menuList)
                    }
                } catch (e: Exception) {

                }
            } else {
                localDBRepository.insertMenu(dataX)
                try {
                    menuList =
                        networkRepository.getMenuList(header, dataX.restaurant_id)
                    withContext(Dispatchers.Main) {
                        updateRestaurantMenu(menuList)
                    }
                } catch (e: Exception) {

                }
            }
        }
    }
}

class RestaurantMenuViewHolder(val restaurantMenuCardViewBinding: RestaurantMenuCardviewBinding) :
    RecyclerView.ViewHolder(restaurantMenuCardViewBinding.root) {

    interface OnMenuButtonClickedListener {
        fun onMenuButtonClicked(dataX: DataX)
    }
}