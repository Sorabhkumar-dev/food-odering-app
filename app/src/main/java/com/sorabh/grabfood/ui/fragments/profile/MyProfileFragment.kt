package com.sorabh.grabfood.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentMyProfileBinding
import com.sorabh.grabfood.util.Keys
import kotlinx.coroutines.*


class MyProfileFragment : Fragment() {
    private lateinit var binding:FragmentMyProfileBinding
    private val job = SupervisorJob()
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
        CoroutineScope(job + Dispatchers.IO).launch {
            val sharedPreferences =
                requireContext().getSharedPreferences(Keys.LOGIN, AppCompatActivity.MODE_PRIVATE)
            val name = sharedPreferences.getString(Keys.NAME, getString(R.string.na))
            val email = sharedPreferences.getString(Keys.EMAIL, getString(R.string.na))
            val address = sharedPreferences.getString(Keys.Address, getString(R.string.na))
            val phone = sharedPreferences.getString(Keys.MOBILE_NUMBER, getString(R.string.na))

            withContext(job + Dispatchers.Main) {
                binding.txtProfileAdd.text = address
                binding.txtProfileEmail.text = email
                binding.txtProfilePhone.text = phone
                binding.txtProfileName.text = name
            }
        }
    }
}