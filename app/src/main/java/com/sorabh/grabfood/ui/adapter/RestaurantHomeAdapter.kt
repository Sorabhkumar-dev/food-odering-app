package com.sorabh.grabfood.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RestaurantHomeAdapter @Inject constructor() : RecyclerView.Adapter<RestaurantViewHolder>() {
    var restaurantsClicked: RestaurantViewHolder.OnRestaurantsClicked? = null

    lateinit var insertRestaurant: suspend (Dish) -> Boolean
    lateinit var deleteRestaurant: suspend (Dish) -> Boolean
    lateinit var isRestaurantStored: suspend (String) -> Boolean
    private var restaurantsList: MutableList<Dish> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RestaurantViewHolder(
            RestaurantsHomeCardviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            if (isRestaurantStored(restaurantsList[position].id))
                holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_adapter)
            else
                holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_empty)

            holder.binding.data = restaurantsList[position]
            holder.binding.onRestaurantClicked = restaurantsClicked
            holder.binding.onFavoriteButtonClicked =
                object : RestaurantViewHolder.OnFavoriteButtonClicked {
                    override fun onFavoriteButtonClicked(dish: Dish) {
                        CoroutineScope(Dispatchers.Main).launch {
                            if (isRestaurantStored(dish.id)) {
                                if (deleteRestaurant(dish))
                                    holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_empty)
                            } else {
                                if (insertRestaurant(dish))
                                    holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_adapter)
                            }
                        }
                    }
                }
            holder.binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int = restaurantsList.size

    fun updateRestaurantsList(newList: List<Dish>?) {
        newList?.let {
            restaurantsList.clear()
            restaurantsList.addAll(it)
            notifyDataSetChanged()
        }
    }
}

class RestaurantViewHolder(val binding: RestaurantsHomeCardviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    interface OnFavoriteButtonClicked {
        fun onFavoriteButtonClicked(dish: Dish)
    }

    interface OnRestaurantsClicked {
        fun onRestaurantsClicked(dish: Dish)
    }
}