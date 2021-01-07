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
import com.example.recyclerview_sticky_headerfooter_example.databinding.FragmentMainTabFirstBinding
import com.example.recyclerview_sticky_headerfooter_example.databinding.FragmentMainTabThirdBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainTabThirdFragment : BindingFragment<FragmentMainTabThirdBinding>()  {

    companion object {
        val TAG: String = MainTabThirdFragment::class.java.simpleName
        fun newInstance() = MainTabThirdFragment()
    }

    private lateinit var mVM: MainTabViewModel

    @LayoutRes
    override fun getLayoutResId() = R.layout.fragment_main_tab_third

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = getViewModel()
        binding.lifecycleOwner = viewLifecycleOwner

        binding.vm?.let {
            mVM = it
        }
    }
}