package com.sorabh.grabfood.domain.repository

import com.sorabh.grabfood.domain.database.LocalDAO
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.util.QNAData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDBRepositoryImpl @Inject constructor(private val localDAO: LocalDAO) :
    LocalDBRepository {

    // Restaurant Home
    override suspend fun insertRestaurant(dish: Dish) = localDAO.insertRestaurant(dish)

    override suspend fun deleteRestaurant(dish: Dish) = localDAO.deleteRestaurant(dish)


    override fun getRestaurantList() = localDAO.getRestaurantList()

    override fun getRestaurant(id: String) = localDAO.getRestaurant(id)


    override suspend fun insertMenu(menu: Menu) = localDAO.insertMenu(menu)



    override suspend fun deleteMenu(menu: Menu) = localDAO.deleteMenu(menu)


    override fun getMenuList() = localDAO.getMenuList()

    override fun getMenuItem(id: String): Flow<Int> = localDAO.getMenuItem(id)


    // Restaurant QNA

    override fun upsertQNAs(questions: List<QNAData>) = localDAO.upsertQNAs(questions)


    override fun getQNAList(): List<QNAData> = localDAO.getQNAList()

}