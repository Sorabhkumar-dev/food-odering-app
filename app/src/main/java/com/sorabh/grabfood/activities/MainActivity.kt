package com.sorabh.grabfood.activities

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.textview.MaterialTextView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.ActivityMainBinding
import com.sorabh.grabfood.fragments.cart.CartFragment
import com.sorabh.grabfood.fragments.favorites.FavoriteRestaurantsFragment
import com.sorabh.grabfood.fragments.history.OderHistoryFragment
import com.sorabh.grabfood.fragments.home.HomeFragment
import com.sorabh.grabfood.fragments.profile.MyProfileFragment
import com.sorabh.grabfood.fragments.qna.QNAFragment

class MainActivity : AppCompatActivity() {
    private lateinit var headerView: View
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //initializing toolBar
        setUpActionbar(mainBinding.toolBar)

        mainBinding.searchView.isVisible = false
        //for easy traction of drawer navigation
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            mainBinding.drawerLayout,
            R.string.action_open,
            R.string.action_close
        )
        mainBinding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        //default fragment that will be show to user
        changeFragmentAndTitle(HomeFragment(mainBinding), "Restaurant List", mainBinding)

        //exacting data from sharedPreference
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "unknown")
        val email = sharedPreferences.getString("email", "unknown")

        //exacting  navigation's header layout view
        headerView = mainBinding.navigationView.getHeaderView(0)
        headerView.findViewById<MaterialTextView>(R.id.txt_main_username).text = name
        headerView.findViewById<MaterialTextView>(R.id.txt_main_email).text = email


        //working with navigation menu components
        mainBinding.navigationView.setNavigationItemSelectedListener {
            //changing fragment with there respective menu id
            when (it.itemId) {
                R.id.drawer_menu_home -> {
                    changeFragmentAndTitle(
                        HomeFragment(mainBinding),
                        "Restaurant List",
                        mainBinding
                    )
                    it.isChecked = true

                }
                R.id.drawer_menu_profile -> {
                    changeFragmentAndTitle(MyProfileFragment(mainBinding), "My Profile", mainBinding)
                    it.isChecked = true

                }
                R.id.drawer_menu_cart -> {
                    changeFragmentAndTitle(CartFragment(mainBinding), "My cart", mainBinding)
                    it.isChecked = true
                }
                R.id.drawer_menu_history -> {
                    changeFragmentAndTitle(OderHistoryFragment(mainBinding), "Oder History", mainBinding)
                    it.isChecked = true

                }
                R.id.drawer_menu_qna -> {
                    changeFragmentAndTitle(QNAFragment(mainBinding), "Frequently Asked Question", mainBinding)
                    it.isChecked = true

                }
                R.id.drawer_menu_favorite -> {
                    changeFragmentAndTitle(
                        FavoriteRestaurantsFragment(mainBinding),
                        "My Favorite Restaurants",
                        mainBinding
                    )
                    it.isChecked = true


                }

                // logout from the app and redirect user from login activity
                R.id.drawer_menu_logout -> {
                    confirmLogOutDialog()
                    it.isChecked = true
                    mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
                }

            }
            return@setNavigationItemSelectedListener true
        }

    }

    //for fragment transaction between fragment
    private fun changeFragmentAndTitle(
        fragment: Fragment,
        title: String,
        mainBinding: ActivityMainBinding
    ) {
        supportActionBar?.title = title
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            .addToBackStack(fragment.toString())
            .replace(R.id.frameLayout, fragment)
            .commit()
        mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    //for toolbar setup
    private fun setUpActionbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Home"
    }

    //to listen event on  hamburger icon click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            mainBinding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    //confirm dialog
    private fun confirmLogOutDialog() {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Are You Want to Log Out!")
        alertDialog.setMessage("After clicking Yes you will be log out from the App.")
        alertDialog.setIcon(R.drawable.icon_grabfood)
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LogOut") { _: DialogInterface, _: Int ->
            val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
            Toast.makeText(
                this,
                "You Log Out Successfully from GrabFood",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
            finish()


        }
        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE,
            "Keep LogIn"
        ) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        alertDialog.show()
    }
}
