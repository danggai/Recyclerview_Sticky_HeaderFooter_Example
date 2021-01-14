package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.recyclerview_sticky_headerfooter_example.BindingFragment
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.databinding.FragmentMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainFragment : BindingFragment<FragmentMainBinding>() {

    companion object {
        val TAG: String = MainFragment::class.java.simpleName
        fun newInstance() = MainFragment()
    }

    private lateinit var mVM: MainViewModel

    @LayoutRes
    override fun getLayoutResId() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = getViewModel()
        binding.lifecycleOwner = viewLifecycleOwner

        binding.vm?.let {
            mVM = it
        }

        initUI()
    }

    private fun initUI() {
        val vp2: ViewPager2 = binding.viewPager2
        vp2.adapter = MainPager2Adapter(this)

        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, vp2) { tab, position ->
            when (position) {
                0 -> { tab.text = "Sticky Header"}
                1 -> { tab.text = "Sticky Footer"}
                2 -> { tab.text = "Sticky Header/Footer"}
            }
            vp2.setCurrentItem(tab.position, true)
        }.attach()
    }
}