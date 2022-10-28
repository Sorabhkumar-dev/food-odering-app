package com.sorabh.grabfood.ui.fragments.qna

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentQNABinding
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.ui.adapter.QNAAdapter
import com.sorabh.grabfood.util.QNAData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class QNAFragment : Fragment() {
    private val job = SupervisorJob()
    private lateinit var binding: FragmentQNABinding
    @Inject
    lateinit var localRepository: LocalDBRepository
    @Inject
    lateinit var qnaAdapter: QNAAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer()
        setupData()
        return binding.root
    }

    private fun startupInitializer() {
        binding = FragmentQNABinding.inflate(layoutInflater)
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.frequently_asked_question)
        binding.qnaRecyclerView.adapter = qnaAdapter
    }

    private fun setupData() {
        CoroutineScope(job + Dispatchers.IO).launch {
            if (localRepository.getQNAList().isNullOrEmpty()) {
                createQna()
            }
            val qnaList = localRepository.getQNAList()
            withContext(Dispatchers.Main) {
                binding.qnaProgressBar.visibility = ProgressBar.GONE
                qnaAdapter.updateList(qnaList)
            }
        }
    }


    private fun createQna() = CoroutineScope(job + Dispatchers.IO).launch {
        val q1 = QNAData(
            1, "How to search city wise restaurant?", "\n" +
                    "To search restaurants in particular city is very simple with foodchow. Enter preferred city name in search bar and click on search. All restaurant listed in searched city will be display."
        )

        localRepository.insertQNAData(q1)

        val q2 = QNAData(
            2,
            "How to search restaurants of different country?",
            "To discover restaurants of different countries is very easy with foodchow. User can view restaurant of various countries on foodchow. Scroll down welcome page of foodchow and click on the country flag to view restaurant of that particular country."
        )

        localRepository.insertQNAData(q2)

        val q3 = QNAData(
            3, "How to register restaurant on foodchow?",
            "Anyone can start their restaurant business online within few minutes. Click on Add Your Restaurant from foodchow welcome page. Enter your mail id and receive mail to add your restaurant details. Add whole details and restaurant will be online."
        )
        localRepository.insertQNAData(q3)

        val q4 = QNAData(
            4,
            "How to search restaurant for particular cuisine?",
            "On foodchow you can also find restaurant according to your choice of cuisine. Search restaurant list in your city and click on your favourite cuisine from left hand side panel. All restaurants will be listed with your selected cuisine."
        )
        localRepository.insertQNAData(q4)

        val q5 = QNAData(
            5,
            "How to go on particular restaurant page?",
            "There are multiple ways to go on particular restaurant page. Search restaurant city wise or cuisine wise and select restaurant from list. Foodchow providing one unique functionality too i.e. unique URL for every restaurant. If restaurant URL on foodchow is known then type URL and directly go to restaurant page."
        )
        localRepository.insertQNAData(q5)

        val q6 = QNAData(
            6,
            "How to view only non-veg item from restaurant menu?",
            "Searching your favourite item from whole menu is headache. Foodchow providing solution for this also. If you are interested in only Non-Veg items then view menu of only Non-Veg items. Go to Cuisine page of your selected restaurant and click on Non-Veg."
        )
        localRepository.insertQNAData(q6)

        val q7 = QNAData(
            7,
            "How to view only Veg item from restaurant menu?",
            "Searching your favourite item from whole menu is headache. Foodchow providing solution for this also. If you are interested in only Pure Veg items then view menu of only Veg items. Go to Cuisine page of your selected restaurant and click on Pure-Veg."
        )
        localRepository.insertQNAData(q7)

        val q8 = QNAData(
            8,
            "How to view restaurant details?",
            "Foodchow providing personal pages for every restaurant to add their details and contents. Customer can view details of restaurant from restaurant page. Go to restaurant page and click on About to view details of restaurant."
        )
        localRepository.insertQNAData(q8)

        val q9 = QNAData(
            9,
            "How to view reviews for particular restaurant?",
            "On foodchow customer can also provide rating to restaurant so that other customer will able to view those review. Go to any restaurant page and scroll down to view reviews/rating of that particular restaurant."
        )
        localRepository.insertQNAData(q9)

        val q10 = QNAData(
            10,
            "How to give rating to particular restaurant?",
            "To improve performance of anything feedback of customer is very important. Foodchow also providing facility to give your feedback to restaurants. Just few simple clicks and your feedback will be recorded. Go to About page of any restaurant and Click on Add Reviews. Give your feedback and it will be display on particular restaurant page."
        )
        localRepository.insertQNAData(q10)

        val q11 = QNAData(
            11,
            "How to login to Admin Panel?",
            "On foodchow every restaurant owner has their own admin panel from where owner can manage their restaurant details. For login to admin panel of restaurant, restaurant owner have to go to their restaurant page. Owner have to click on Restaurant Login to login in admin panel of restaurant."
        )
        localRepository.insertQNAData(q11)

        val q12 = QNAData(
            12,
            "How to view social media pages of restaurant?",
            "Restaurant owner can list out their restaurant pages of various social media too, so that customer can visit those pages. Customer can view link of social media page of restaurant from restaurant page. Customer have to go to restaurant page and scroll down for social media page link of URL."
        )
        localRepository.insertQNAData(q12)

        val q13 = QNAData(
            13,
            "How to view restaurant menu?",
            "Customer have to go to restaurant page to view menu of restaurant. From Cuisine option on restaurant page customer can view menu of that restaurant."
        )

        localRepository.insertQNAData(q13)

        val q14 = QNAData(
            14,
            "From where we can login to Customer account?",
            "Customer can also register themselves on Foodchow if they are regular user of foodchow. Customer have to click on Login option from any restaurant page to login to their panel."
        )
        localRepository.insertQNAData(q14)

        val q15 = QNAData(
            15,
            " How to sign up as a new customer?",
            "Customer should register themselves on foodchow if they are regular user of foodchow. They can register themselves on foodchow by few simple clicks. They to go to Login option on any restaurant and click on I am a New User."
        )
        localRepository.insertQNAData(q15)

        val q16 = QNAData(
            16,
            "How can customer can view history of placed order from foodchow?",
            "If you are register user of foodchow you can maintain order history of yours. You just have to login to your user account and click on My Orders to view full order details and history."
        )
        localRepository.insertQNAData(q16)

        val q17 = QNAData(
            17,
            "How to change password of customer account?",
            "Customer can change password of their panel by going to My Profile after login to their account. After changing the password of customer account customer can login to account using new password."
        )
        localRepository.insertQNAData(q17)

        val q18 = QNAData(
            18,
            " Can user place order if user is not registered on foodchow?",
            "To place order on foodchow you don’t have to register yourself on foodchow. You can place order on foodchow as a guest user. After adding item to cart they have to select Guest option to place order as guest user."
        )
        localRepository.insertQNAData(q18)

        val q19 = QNAData(
            19,
            "How can customer send special request or instruction about food while placing orders?",
            "Foodchow is providing you facility to send your special request or notes to restaurant with your order. You can write your special notes at the time of providing information of your address and all."
        )
        localRepository.insertQNAData(q19)

        val q20 = QNAData(
            20,
            "How can customer change ingredients or customize item ?",
            "Foodchow providing feature to customize item while placing order for food. If restaurant owner have provided functionality to customize the item. User have to open menu of the restaurant and click on Customize for item which you want to customize. You can change the ingredients or add more ingredients to item according to your choice."
        )
        localRepository.insertQNAData(q20)

        val q21 = QNAData(
            21,
            "How to join newsletter for new offers and new?",
            "You can join newsletter for upcoming offers and news. You can join newsletter of any restaurant from home page of respective restaurant. You have to enter your email id to join newsletter."
        )
        localRepository.insertQNAData(q21)

        val q22 = QNAData(
            22,
            "Who will receive payment of orders?",
            "Restaurant owner will get whole payment of orders placed through Foodchow. They have to set their own PayPal Account for online transaction."
        )
        localRepository.insertQNAData(q22)

        val q23 = QNAData(
            23,
            "Who will issue refund for order cancellation or other issue?",
            "To customer, refund will be issue by restaurant owner only. Foodchow is not responsible for order cancellation or refund of the order."
        )
        localRepository.insertQNAData(q23)

        val q24 = QNAData(
            24,
            "Do I need to pay extra charges for online payment or online orders?",
            "All extra charges are taken by restaurant owner. Foodchow is not taking any extra charges for online payment or online orders."
        )
        localRepository.insertQNAData(q24)
    }
}