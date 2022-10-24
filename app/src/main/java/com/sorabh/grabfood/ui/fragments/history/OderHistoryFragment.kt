package com.sorabh.grabfood.fragments.history

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorabh.grabfood.R
import com.sorabh.grabfood.activities.MainActivity
import com.sorabh.grabfood.adapter.OrderHistoryAdapter
import com.sorabh.grabfood.api_response_classes.oder_history_response.Data
import com.sorabh.grabfood.databinding.ActivityMainBinding
import com.sorabh.grabfood.databinding.FragmentOderHistoryBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import kotlinx.coroutines.*


class OderHistoryFragment(private val mainBinding: ActivityMainBinding) : Fragment() {
    private lateinit var oderHistoryBinding: FragmentOderHistoryBinding

    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        oderHistoryBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_oder_history,
            container,
            false
        )

        //Changing toolbar title
        (activity as MainActivity).supportActionBar?.title = "Oder History"

        //hide the appBarLayout searchView
        mainBinding.searchView.isVisible = false

        val linearLayoutManager = LinearLayoutManager(activity as Context)
        val historyAdapter = OrderHistoryAdapter(activity as Context)
        with(oderHistoryBinding.orderHistoryFragmentRecyclerView) {
            layoutManager = linearLayoutManager
            adapter = historyAdapter
        }
        CoroutineScope(job + Dispatchers.Main).launch {
            try {
                val data = getOderHistory()

                Log.d("exc_his", data.toString())
                if (data?.success == true) {
                    val list = data.data
                    historyAdapter.updateOderHistoryList(list)
                    oderHistoryBinding.orderHistoryFragmentProgressBar.visibility = ProgressBar.GONE
                }
            } catch (e: Exception) {
                withContext(job + Dispatchers.Main) {
                    Toast.makeText(
                        activity as Context,
                        "Couldn't connect to server!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return oderHistoryBinding.root
    }


    //exacting oder history
    private suspend fun getOderHistory(): Data? = coroutineScope {
        val oderHistoryList = CoroutineScope(job + Dispatchers.IO).async {
            val sharedPreferences =
                activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
            val userId: String? = sharedPreferences?.getString("user_id", "107")
            val repository = NetworkRepository()

            //header to send
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json"
            header["token"] = "025c40375fadfd"

            return@async repository.getOderHistory(header, userId)

        }
        return@coroutineScope oderHistoryList.await()
    }

    override fun onDestroy() {
        super.onDestroy()
        oderHistoryBinding.unbind()
    }
}