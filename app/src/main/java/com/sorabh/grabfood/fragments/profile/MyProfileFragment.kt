package com.sorabh.grabfood.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sorabh.grabfood.R
import com.sorabh.grabfood.activities.MainActivity
import com.sorabh.grabfood.databinding.FragmentMyProfileBinding
import kotlinx.coroutines.*


class MyProfileFragment : Fragment() {
    private lateinit var fragmentMyProfileBinding: FragmentMyProfileBinding
    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
      fragmentMyProfileBinding =DataBindingUtil.inflate(layoutInflater,R.layout.fragment_my_profile, container, false)

        //Changing toolbar title
        (activity as MainActivity).supportActionBar!!.title = "My Profile"

        CoroutineScope(job+Dispatchers.IO).launch {
            val sharedPreferences = (activity as MainActivity).getSharedPreferences("login",AppCompatActivity.MODE_PRIVATE)
            val name = sharedPreferences.getString("name","unknown")
            val email = sharedPreferences.getString("email","unknown")
            val address = sharedPreferences.getString("address","unknown")
            val phone = sharedPreferences.getString("mobile_number","unknown")


            withContext(job+Dispatchers.Main){
                fragmentMyProfileBinding.txtProfileAdd.text = address
                fragmentMyProfileBinding.txtProfileEmail.text = email
                fragmentMyProfileBinding.txtProfilePhone.text = phone
                fragmentMyProfileBinding.txtProfileName.text = name
            }
        }
        return fragmentMyProfileBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMyProfileBinding.unbind()
    }
}