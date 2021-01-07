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
import com.example.recyclerview_sticky_headerfooter_example.BindingFragment
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.databinding.FragmentMainBinding
import com.example.recyclerview_sticky_headerfooter_example.databinding.FragmentMainTabFirstBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainTabFirstFragment : BindingFragment<FragmentMainTabFirstBinding>() {

    companion object {
        val TAG: String = MainTabFirstFragment::class.java.simpleName
        fun newInstance() = MainTabFirstFragment()
    }

    private lateinit var mVM: MainTabViewModel

    @LayoutRes
    override fun getLayoutResId() = R.layout.fragment_main_tab_first

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = getViewModel()
        binding.lifecycleOwner = viewLifecycleOwner

        binding.vm?.let {
            mVM = it
        }
    }
}