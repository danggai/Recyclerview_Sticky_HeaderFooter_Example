package com.example.recyclerview_sticky_headerfooter_example.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPager2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {
        const val itemSize = 3
        const val TYPE_TAB_FIRST = 0
        const val TYPE_TAB_SECOND = 1
        const val TYPE_TAB_THIRD = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_TAB_FIRST
            1 -> TYPE_TAB_SECOND
            else -> TYPE_TAB_THIRD
        }
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            TYPE_TAB_FIRST -> {
                MainTabFirstFragment()
            }
            TYPE_TAB_SECOND -> {
                MainTabSecondFragment()
            }
            else -> {
                MainTabThirdFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return itemSize
    }
}