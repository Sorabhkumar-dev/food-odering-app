package com.sorabh.grabfood.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sorabh.grabfood.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity)
    }
}