package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.example.recyclerview_sticky_headerfooter_example.BindingActivity
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BindingActivity<ActivityMainBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, MainFragment.newInstance(), MainFragment.TAG)
            .commit()
    }
}