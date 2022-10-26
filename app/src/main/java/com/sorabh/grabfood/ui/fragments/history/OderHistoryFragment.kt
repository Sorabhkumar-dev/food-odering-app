package com.sorabh.grabfood.ui.fragments.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentOderHistoryBinding
import com.sorabh.grabfood.domain.model.post.OderHistoryPost
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.adapter.OrderHistoryAdapter
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OderHistoryFragment : BaseFragment() {

    private val viewModel: OderHistoryVieModel by viewModels()
    private lateinit var binding: FragmentOderHistoryBinding

    @Inject
    lateinit var repository: NetworkRepository
    @Inject
    lateinit var historyAdapter: OrderHistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer(inflater)
        setupApiCall()
        setupObserver()
        return binding.root
    }

    private fun startupInitializer(inflater: LayoutInflater) {
        binding = FragmentOderHistoryBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.oder_history)
        binding.orderHistoryFragmentRecyclerView.adapter = historyAdapter
    }

    private fun setupApiCall() {
        val sharedPreferences =
            activity?.getSharedPreferences(Keys.LOGIN, AppCompatActivity.MODE_PRIVATE)
        //header to send
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN

        sharedPreferences?.getString(Keys.USER_ID, "107")?.let {
            viewModel.getOderHistory(OderHistoryPost(header, it))
        }
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.oderHistoryFlow.collect {
                    when (it) {
                        is Result.Error -> {}
                        is Result.Loading -> {}
                        is Result.Success -> {
                            it.body?.data?.data?.let { lists ->
                                binding.orderHistoryFragmentProgressBar.visibility =
                                    ProgressBar.GONE
                                historyAdapter.updateOderHistoryList(lists)
                            }
                        }
                    }
                }
            }
        }
    }
}