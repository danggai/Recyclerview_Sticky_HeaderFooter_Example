package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
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
        val sectionsPagerAdapter = MainPager2Adapter()
        val viewPager2: ViewPager2 = binding.viewPager2
        viewPager2.adapter = sectionsPagerAdapter

        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            when (position) {
                0 -> { tab.text = "TAB 1"}
                1 -> { tab.text = "TAB 2"}
                2 -> { tab.text = "TAB 3"}
            }
            viewPager2.setCurrentItem(tab.position, true)
        }.attach()

        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}