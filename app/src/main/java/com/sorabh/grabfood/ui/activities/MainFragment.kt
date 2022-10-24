package com.sorabh.grabfood.ui.activities

import android.content.Context.MODE_PRIVATE
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.textview.MaterialTextView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.MainFragmentBinding
import com.sorabh.grabfood.ui.fragments.cart.CartFragment
import com.sorabh.grabfood.ui.fragments.favorites.FavoriteRestaurantsFragment
import com.sorabh.grabfood.ui.fragments.history.OderHistoryFragment
import com.sorabh.grabfood.ui.fragments.home.HomeFragment
import com.sorabh.grabfood.ui.fragments.profile.MyProfileFragment
import com.sorabh.grabfood.ui.fragments.qna.QNAFragment
import com.sorabh.grabfood.ui.fragments.home.BaseFragment

class MainFragment : BaseFragment() {
    private lateinit var headerView: View
    private lateinit var binding: MainFragmentBinding
    private lateinit var navController: NavController
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = MainFragmentBinding.inflate(layoutInflater)
        navController = findNavController()

        //initializing toolBar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolBar)

        //for easy traction of drawer navigation
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            requireActivity(),
            binding.drawerLayout,
            binding.toolBar,
            R.string.action_open,
            R.string.action_close
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        //default fragment that will be show to user
        changeFragmentAndTitle(HomeFragment(), "Restaurant List", binding)

        //exacting data from sharedPreference
        sharedPreferences = requireContext().getSharedPreferences("login", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "unknown")
        val email = sharedPreferences.getString("email", "unknown")

        //exacting  navigation's header layout view
        headerView = binding.navigationView.getHeaderView(0)
        headerView.findViewById<MaterialTextView>(R.id.txt_main_username).text = name
        headerView.findViewById<MaterialTextView>(R.id.txt_main_email).text = email


        //working with navigation menu components
        binding.navigationView.setNavigationItemSelectedListener {
            //changing fragment with there respective menu id
            when (it.itemId) {
                R.id.drawer_menu_home -> {
                    changeFragmentAndTitle(
                        HomeFragment(),
                        "Restaurant List",
                        binding
                    )
                    binding.searchView.isVisible = true
                    it.isChecked = true

                }
                R.id.drawer_menu_profile -> {
                    changeFragmentAndTitle(MyProfileFragment(), "My Profile", binding)
                    binding.searchView.isVisible = false
                    it.isChecked = true

                }
                R.id.drawer_menu_cart -> {
                    changeFragmentAndTitle(CartFragment(), "My cart", binding)
                    binding.searchView.isVisible = false
                    it.isChecked = true
                }
                R.id.drawer_menu_history -> {
                    changeFragmentAndTitle(OderHistoryFragment(), "Oder History", binding)
                    binding.searchView.isVisible = false
                    it.isChecked = true

                }
                R.id.drawer_menu_qna -> {
                    changeFragmentAndTitle(QNAFragment(), "Frequently Asked Question", binding)
                    binding.searchView.isVisible = false
                    it.isChecked = true

                }
                R.id.drawer_menu_favorite -> {
                    changeFragmentAndTitle(
                        FavoriteRestaurantsFragment(),
                        "My Favorite Restaurants",
                        binding
                    )
                    binding.searchView.isVisible = false
                    it.isChecked = true


                }

                // logout from the app and redirect user from login activity
                R.id.drawer_menu_logout -> {
                    confirmLogOutDialog()
                    it.isChecked = true
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }

            }
            return@setNavigationItemSelectedListener true
        }
        return binding.root
    }

    //for fragment transaction between fragment
    private fun changeFragmentAndTitle(
        fragment: Fragment,
        title: String,
        binding: MainFragmentBinding
    ) {
        (activity as AppCompatActivity).supportActionBar?.title = title
        childFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            .addToBackStack(fragment.toString())
            .replace(R.id.frameLayout, fragment)
            .commit()
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    //for toolbar setup
//    private fun setUpActionbar(toolbar: Toolbar?) {
//        (activity as AppCompatActivity).setSupportActionBar(toolbar)
//        (activity as AppCompatActivity).supportActionBar?.setHomeButtonEnabled(true)
//        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        (activity as AppCompatActivity).supportActionBar?.title = "Home"
//    }

    //to listen event on  hamburger icon click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    //confirm dialog
    private fun confirmLogOutDialog() {
        val alertDialog = AlertDialog.Builder(requireContext()).create()
        alertDialog.setTitle("Are You Want to Log Out!")
        alertDialog.setMessage("After clicking Yes you will be log out from the App.")
        alertDialog.setIcon(R.drawable.icon_grabfood)
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LogOut") { _: DialogInterface, _: Int ->
            val sharedPreferences = requireContext().getSharedPreferences("login", MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
            Toast.makeText(
                context,
                "You Log Out Successfully from GrabFood",
                Toast.LENGTH_SHORT
            ).show()
            navController.navigate(
                MainFragmentDirections.actionMainFragmentToLoginFragment()
            )
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE,
            "Keep LogIn"
        ) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        alertDialog.show()
    }

    override fun onResume() {
        super.onResume()
        binding.searchView.isVisible = true

    }
}
