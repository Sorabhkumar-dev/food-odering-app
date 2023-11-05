package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.util.QNAData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QNAViewModel @Inject constructor(private val localDBRepository:LocalDBRepository) :
    ViewModel() {
    var qna: MutableList<QNAData> = mutableListOf()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            createQna()
            qna.addAll(localDBRepository.getQNAList())
        }
    }

    private fun createQna() {
        if (localDBRepository.getQNAList().isEmpty()) {
            val questions = listOf(
                QNAData(
                    1, "How to search city wise restaurant?", "\n" +
                            "To search restaurants in particular city is very simple with food chow. Enter preferred city name in search bar and click on search. All restaurant listed in searched city will be display."
                ), QNAData(
                    2,
                    "How to search restaurants of different country?",
                    "To discover restaurants of different countries is very easy with food chow. User can view restaurant of various countries on food chow. Scroll down welcome page of food chow and click on the country flag to view restaurant of that particular country."
                ), QNAData(
                    3, "How to register restaurant on food chow?",
                    "Anyone can start their restaurant business online within few minutes. Click on Add Your Restaurant from food chow welcome page. Enter your mail id and receive mail to add your restaurant details. Add whole details and restaurant will be online."
                ), QNAData(
                    4,
                    "How to search restaurant for particular cuisine?",
                    "On food chow you can also find restaurant according to your choice of cuisine. Search restaurant list in your city and click on your favourite cuisine from left hand side panel. All restaurants will be listed with your selected cuisine."
                ), QNAData(
                    5,
                    "How to go on particular restaurant page?",
                    "There are multiple ways to go on particular restaurant page. Search restaurant city wise or cuisine wise and select restaurant from list. Food chow providing one unique functionality too i.e. unique URL for every restaurant. If restaurant URL on food chow is known then type URL and directly go to restaurant page."
                ), QNAData(
                    6,
                    "How to view only non-veg item from restaurant menu?",
                    "Searching your favourite item from whole menu is headache. Food chow providing solution for this also. If you are interested in only Non-Veg items then view menu of only Non-Veg items. Go to Cuisine page of your selected restaurant and click on Non-Veg."
                ), QNAData(
                    7,
                    "How to view only Veg item from restaurant menu?",
                    "Searching your favourite item from whole menu is headache. Food chow providing solution for this also. If you are interested in only Pure Veg items then view menu of only Veg items. Go to Cuisine page of your selected restaurant and click on Pure-Veg."
                ), QNAData(
                    8,
                    "How to view restaurant details?",
                    "Food chow providing personal pages for every restaurant to add their details and contents. Customer can view details of restaurant from restaurant page. Go to restaurant page and click on About to view details of restaurant."
                ), QNAData(
                    9,
                    "How to view reviews for particular restaurant?",
                    "On food chow customer can also provide rating to restaurant so that other customer will able to view those review. Go to any restaurant page and scroll down to view reviews/rating of that particular restaurant."
                ), QNAData(
                    10,
                    "How to give rating to particular restaurant?",
                    "To improve performance of anything feedback of customer is very important. Food chow also providing facility to give your feedback to restaurants. Just few simple clicks and your feedback will be recorded. Go to About page of any restaurant and Click on Add Reviews. Give your feedback and it will be display on particular restaurant page."
                ), QNAData(
                    11,
                    "How to login to Admin Panel?",
                    "On food chow every restaurant owner has their own admin panel from where owner can manage their restaurant details. For login to admin panel of restaurant, restaurant owner have to go to their restaurant page. Owner have to click on Restaurant Login to login in admin panel of restaurant."
                ), QNAData(
                    12,
                    "How to view social media pages of restaurant?",
                    "Restaurant owner can list out their restaurant pages of various social media too, so that customer can visit those pages. Customer can view link of social media page of restaurant from restaurant page. Customer have to go to restaurant page and scroll down for social media page link of URL."
                ), QNAData(
                    13,
                    "How to view restaurant menu?",
                    "Customer have to go to restaurant page to view menu of restaurant. From Cuisine option on restaurant page customer can view menu of that restaurant."
                ), QNAData(
                    14,
                    "From where we can login to Customer account?",
                    "Customer can also register themselves on Food chow if they are regular user of food chow. Customer have to click on Login option from any restaurant page to login to their panel."
                ), QNAData(
                    15,
                    " How to sign up as a new customer?",
                    "Customer should register themselves on food chow if they are regular user of food chow. They can register themselves on food chow by few simple clicks. They to go to Login option on any restaurant and click on I am a New User."
                ), QNAData(
                    16,
                    "How can customer can view history of placed order from food chow?",
                    "If you are register user of food chow you can maintain order history of yours. You just have to login to your user account and click on My Orders to view full order details and history."
                ), QNAData(
                    17,
                    "How to change password of customer account?",
                    "Customer can change password of their panel by going to My Profile after login to their account. After changing the password of customer account customer can login to account using new password."
                ), QNAData(
                    18,
                    " Can user place order if user is not registered on food chow?",
                    "To place order on food chow you don’t have to register yourself on food chow. You can place order on food chow as a guest user. After adding item to cart they have to select Guest option to place order as guest user."
                ), QNAData(
                    19,
                    "How can customer send special request or instruction about food while placing orders?",
                    "Food chow is providing you facility to send your special request or notes to restaurant with your order. You can write your special notes at the time of providing information of your address and all."
                ), QNAData(
                    20,
                    "How can customer change ingredients or customize item ?",
                    "Food chow providing feature to customize item while placing order for food. If restaurant owner have provided functionality to customize the item. User have to open menu of the restaurant and click on Customize for item which you want to customize. You can change the ingredients or add more ingredients to item according to your choice."
                ), QNAData(
                    21,
                    "How to join newsletter for new offers and new?",
                    "You can join newsletter for upcoming offers and news. You can join newsletter of any restaurant from home page of respective restaurant. You have to enter your email id to join newsletter."
                ), QNAData(
                    22,
                    "Who will receive payment of orders?",
                    "Restaurant owner will get whole payment of orders placed through Food chow. They have to set their own PayPal Account for online transaction."
                ), QNAData(
                    23,
                    "Who will issue refund for order cancellation or other issue?",
                    "To customer, refund will be issue by restaurant owner only. Food chow is not responsible for order cancellation or refund of the order."
                ), QNAData(
                    24,
                    "Do I need to pay extra charges for online payment or online orders?",
                    "All extra charges are taken by restaurant owner. Food chow is not taking any extra charges for online payment or online orders."
                )
            )
            localDBRepository.upsertQNAs(questions)
        }
    }
}