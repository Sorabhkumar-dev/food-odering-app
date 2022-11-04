package com.sorabh.grabfood.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RestaurantMenuAdapter @Inject constructor() : RecyclerView.Adapter<RestaurantMenuViewHolder>(){

    private var restaurantMenuList:MutableList<Menu> = mutableListOf()
    lateinit var insertMenu:suspend (Menu) -> Boolean
    lateinit var deleteMenu:suspend (Menu) -> Boolean
    lateinit var isMenuSaved:suspend (String) -> Boolean

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RestaurantMenuViewHolder(RestaurantMenuCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RestaurantMenuViewHolder, position: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            if (isMenuSaved(restaurantMenuList[position].id)) {
                holder.restaurantMenuCardViewBinding.btnRestaurantMenuAdd.apply {
                    text = context.getString(R.string.remove)
                    setBackgroundColor(Color.parseColor("#FFFF0000"))
                }
            }
            holder.restaurantMenuCardViewBinding.menuData = restaurantMenuList[position]
            holder.restaurantMenuCardViewBinding.sno = "${position + 1}."
            holder.restaurantMenuCardViewBinding.onMenuButtonClicked =
                object : RestaurantMenuViewHolder.OnMenuButtonClickedListener {
                    override fun onMenuButtonClicked(menu: Menu) {
                        CoroutineScope(Dispatchers.Main).launch {
                            if (isMenuSaved(restaurantMenuList[position].id)) {
                                if (deleteMenu(menu))
                                    holder.restaurantMenuCardViewBinding.btnRestaurantMenuAdd.apply {
                                        text = context.getString(R.string.add_to_cart)
                                        setBackgroundColor(Color.parseColor("#028F09"))
                                    }
                            } else {
                                if (insertMenu(menu))
                                    holder.restaurantMenuCardViewBinding.btnRestaurantMenuAdd.apply {
                                        text = context.getString(R.string.remove)
                                        setBackgroundColor(Color.parseColor("#FFFF0000"))
                                    }
                            }
                        }
                    }
                }
            holder.restaurantMenuCardViewBinding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int = restaurantMenuList.size

    fun updateRestaurantMenu(newMenu: List<Menu>?) {
        newMenu?.let {
            restaurantMenuList.clear()
            restaurantMenuList.addAll(it)
            notifyDataSetChanged()
        }
    }
}
class RestaurantMenuViewHolder(val restaurantMenuCardViewBinding: RestaurantMenuCardviewBinding) :
    RecyclerView.ViewHolder(restaurantMenuCardViewBinding.root) {

    interface OnMenuButtonClickedListener {
        fun onMenuButtonClicked(menu: Menu)
    }
}