package com.sorabh.grabfood.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sorabh.grabfood.databinding.FragmentMyProfileBinding
import kotlinx.coroutines.*


class MyProfileFragment : Fragment() {
    private lateinit var binding:FragmentMyProfileBinding
    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
      binding = FragmentMyProfileBinding.inflate(layoutInflater)

        //Changing toolbar title
        (activity as AppCompatActivity).supportActionBar!!.title = "My Profile"


        CoroutineScope(job+Dispatchers.IO).launch {
            val sharedPreferences = requireContext().getSharedPreferences("login",AppCompatActivity.MODE_PRIVATE)
            val name = sharedPreferences.getString("name","unknown")
            val email = sharedPreferences.getString("email","unknown")
            val address = sharedPreferences.getString("address","unknown")
            val phone = sharedPreferences.getString("mobile_number","unknown")


            withContext(job+Dispatchers.Main){
                binding.txtProfileAdd.text = address
                binding.txtProfileEmail.text = email
                binding.txtProfilePhone.text = phone
                binding.txtProfileName.text = name
            }
        }
        return binding.root
    }
}