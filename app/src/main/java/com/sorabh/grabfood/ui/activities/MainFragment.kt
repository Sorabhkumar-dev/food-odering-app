package com.sorabh.grabfood.ui.activities

import android.content.Context.MODE_PRIVATE
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textview.MaterialTextView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.MainFragmentBinding
import com.sorabh.grabfood.ui.fragments.cart.CartFragment
import com.sorabh.grabfood.ui.fragments.favorites.FavoriteRestaurantsFragment
import com.sorabh.grabfood.ui.fragments.history.OderHistoryFragment
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.fragments.home.HomeFragment
import com.sorabh.grabfood.ui.fragments.profile.MyProfileFragment
import com.sorabh.grabfood.ui.fragments.qna.QNAFragment
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        startupInitializer()
        setupDrawerLayout()
        setupHeaderLayout()
        changeFragmentAndTitle(HomeFragment(), getString(R.string.restaurants_list))
        setupNavigationItemSelector()
        return binding.root
    }

    private fun startupInitializer() {
        binding = MainFragmentBinding.inflate(layoutInflater)
        navController = findNavController()
        (activity as AppCompatActivity).setSupportActionBar(binding.toolBar)
    }

    private fun setupDrawerLayout() {
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            requireActivity(),
            binding.drawerLayout,
            binding.toolBar,
            R.string.action_open,
            R.string.action_close
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    private fun setupHeaderLayout() {
        sharedPreferences = requireContext().getSharedPreferences(Keys.LOGIN, MODE_PRIVATE)

        headerView = binding.navigationView.getHeaderView(0)
        headerView.findViewById<MaterialTextView>(R.id.txt_main_username).text =
            sharedPreferences.getString(Keys.NAME, getString(R.string.unknown))

        headerView.findViewById<MaterialTextView>(R.id.txt_main_email).text =
            sharedPreferences.getString(Keys.EMAIL, getString(R.string.unknown))
    }

    private fun setupNavigationItemSelector() {
        binding.navigationView.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
                R.id.drawer_menu_home -> {
                    changeFragmentAndTitle(HomeFragment(), getString(R.string.restaurants_list))
                }
                R.id.drawer_menu_profile -> {
                    changeFragmentAndTitle(MyProfileFragment(), getString(R.string.my_profile))
                }
                R.id.drawer_menu_cart -> {
                    changeFragmentAndTitle(CartFragment(), getString(R.string.my_cart))
                }
                R.id.drawer_menu_history -> {
                    changeFragmentAndTitle(OderHistoryFragment(), getString(R.string.oder_history))
                }
                R.id.drawer_menu_qna -> {
                    changeFragmentAndTitle(QNAFragment(), getString(R.string.frequently_asked))

                }
                R.id.drawer_menu_favorite -> {
                    changeFragmentAndTitle(
                        FavoriteRestaurantsFragment(), getString(R.string.my_favorite_restaurants)
                    )
                }
                R.id.drawer_menu_logout -> {
                    confirmLogOutDialog()
                    it.isChecked = true
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }

            }
            return@setNavigationItemSelectedListener true
        }
    }

    //for fragment transaction between fragment
    private fun changeFragmentAndTitle(
        fragment: Fragment,
        title: String) {
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

    private fun confirmLogOutDialog() {
        val alertDialog = MaterialAlertDialogBuilder(requireContext()).create()
        alertDialog.setTitle(getString(R.string.are_you_sure_to_log_out))
        alertDialog.setMessage(getString(R.string.after_clicking_yes_you_will_be))
        alertDialog.setIcon(R.drawable.icon_grab_food)
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.yes)) { _: DialogInterface, _: Int ->
            val sharedPreferences = requireContext().getSharedPreferences(Keys.LOGIN, MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
            showToast(getString(R.string.you_successfully_log_out_from_the_app))
            navController.navigate(
                MainFragmentDirections.actionMainFragmentToLoginFragment()
            )
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE,
            getString(R.string.discard)
        ) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        alertDialog.show()
    }
}
