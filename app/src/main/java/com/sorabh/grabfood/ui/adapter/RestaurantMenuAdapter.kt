package com.sorabh.grabfood.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestaurantMenuAdapter @Inject constructor(private val localDBRepository: LocalDBRepository) :
    RecyclerView.Adapter<RestaurantMenuViewHolder>(){

    private var restaurantMenuList:MutableList<Menu> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RestaurantMenuViewHolder(RestaurantMenuCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RestaurantMenuViewHolder, position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val menuData: Menu? = localDBRepository.getMenuItem(restaurantMenuList[position].id)
            if (menuData != null) {
                withContext(Dispatchers.Main) {
                    holder.restaurantMenuCardViewBinding.btnRestaurantMenuAdd.apply {
                        text = context.getString(R.string.remove)
                        setBackgroundColor(Color.parseColor("#FFFF0000"))
                    }
                }
            }
        }
        holder.restaurantMenuCardViewBinding.menuData = restaurantMenuList[position]
        holder.restaurantMenuCardViewBinding.sno = "${position + 1}."
        holder.restaurantMenuCardViewBinding.onMenuButtonClicked =
            object : RestaurantMenuViewHolder.OnMenuButtonClickedListener {
                override fun onMenuButtonClicked(menu: Menu) {
                    CoroutineScope(Dispatchers.IO).launch{
                        val data = localDBRepository.getMenuItem(menu.id)
                        if (data != null) {
                            localDBRepository.deleteMenu(menu)
                            withContext(Dispatchers.Main){
                                holder.restaurantMenuCardViewBinding.btnRestaurantMenuAdd.apply {
                                    text = context.getString(R.string.add_to_cart)
                                    setBackgroundColor(Color.parseColor("#028F09"))
                                }
                            }
                        } else {
                            localDBRepository.insertMenu(menu)
                            withContext(Dispatchers.Main){
                                holder.restaurantMenuCardViewBinding.btnRestaurantMenuAdd.apply {
                                    text = context.getString(R.string.remove)
                                    setBackgroundColor(Color.parseColor("#FFFF0000"))
                                }
                            }
                        }
                    }
                }
            }
        holder.restaurantMenuCardViewBinding.executePendingBindings()
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