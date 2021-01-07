package com.example.recyclerview_sticky_headerfooter_example

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.recyclerview_sticky_headerfooter_example.ui.main.SectionsPagerAdapter2
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter2()
        val viewPager2: ViewPager2 = findViewById(R.id.view_pager2)
        viewPager2.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            when (position) {
                0 -> { tab.text = "TAB 1"}
                1 -> { tab.text = "TAB 2"}
                2 -> { tab.text = "TAB 3"}
            }
            viewPager2.setCurrentItem(tab.position, true)
        }.attach()
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}