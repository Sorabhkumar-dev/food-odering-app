package com.sorabh.grabfood.ui.fragments.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import kotlinx.coroutines.flow.first
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
        setOnClickListener()
        setupApiCall()
        setupObserver()
        return binding.root
    }

    private fun setOnClickListener() {
        binding.errorLayout.btnRetry.setOnClickListener {
            binding.errorLayout.root.visibility = View.GONE
            setupApiCall()
        }
    }

    private fun startupInitializer(inflater: LayoutInflater) {
        binding = FragmentOderHistoryBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.oder_history)
        binding.orderHistoryFragmentRecyclerView.adapter = historyAdapter
    }

    private fun setupApiCall() {
        lifecycleScope.launch {
            val header = HashMap<String, String>()
            header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
            header[Keys.TOKEN] = Constants.MAIN_TOKEN

            viewModel.userIdFlow.first().let {
                viewModel.getOderHistory(OderHistoryPost(header, it))
            }
        }
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.oderHistoryFlow.collect {
                    when (it) {
                        is Result.Loading -> {
                            binding.shimmerLayout.startShimmer()
                            binding.shimmerLayout.visibility = View.VISIBLE
                        }
                        is Result.Error -> {
                            binding.shimmerLayout.stopShimmer()
                            binding.shimmerLayout.visibility = View.GONE
                            binding.errorLayout.root.visibility = View.VISIBLE
                            binding.errorLayout.txvReason.text = it.message
                        }
                        is Result.Success -> {
                            binding.shimmerLayout.stopShimmer()
                            binding.shimmerLayout.visibility = View.GONE
                            it.body?.data?.data?.let { lists ->
                                historyAdapter.updateOderHistoryList(lists)
                            }
                        }
                    }
                }
            }
        }
    }
}