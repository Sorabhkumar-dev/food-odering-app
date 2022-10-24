package com.sorabh.grabfood.ui.fragments.home

import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment :Fragment() {
    fun showToast(msg:String?,length:Int = Toast.LENGTH_SHORT){
        msg?.let {
            Toast.makeText(context,it,length).show()
        }
    }
}