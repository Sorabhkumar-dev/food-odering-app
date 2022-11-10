package com.sorabh.grabfood.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentMyProfileBinding
import com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyProfileFragment : Fragment() {
    private lateinit var binding: FragmentMyProfileBinding
    private val viewModel: MyProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyProfileBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.my_profile)
        setupProfileData()
        return binding.root
    }

    private fun setupProfileData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                launch {
                    viewModel.addressFow.collect {
                        binding.txtProfileAdd.text = it
                    }
                }
                launch {
                    viewModel.emailFlow.collect {
                        binding.txtProfileEmail.text = it
                    }
                }
                launch {
                    viewModel.phoneFlow.collect {
                        binding.txtProfilePhone.text = it
                    }
                }
                launch {
                    viewModel.nameFlow.collect {
                        binding.txtProfileName.text = it
                    }
                }
            }
        }
    }
}