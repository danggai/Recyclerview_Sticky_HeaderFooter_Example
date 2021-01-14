package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.example.recyclerview_sticky_headerfooter_example.BindingFragment
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.databinding.FragmentMainTabThirdBinding
import com.example.recyclerview_sticky_headerfooter_example.util.StickyFooterItemDecoration
import com.example.recyclerview_sticky_headerfooter_example.util.StickyHeaderItemDecoration
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainTabThirdFragment : BindingFragment<FragmentMainTabThirdBinding>()  {

    companion object {
        val TAG: String = MainTabThirdFragment::class.java.simpleName
        fun newInstance() = MainTabThirdFragment()
    }

    private lateinit var mVM: MainTabViewModel
    private lateinit var mAdapter: MainTabAdapter

    @LayoutRes
    override fun getLayoutResId() = R.layout.fragment_main_tab_third

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = getViewModel()
        binding.lifecycleOwner = viewLifecycleOwner

        binding.vm?.let {
            mVM = it
        }

        binding.rv.adapter = MainTabAdapter(mVM)
        mAdapter = binding.rv.adapter as MainTabAdapter

        initUI()
        initLv()
    }

    private fun initUI() {
        mAdapter.clear()
        binding.rv.addItemDecoration(
                StickyHeaderItemDecoration(
                        binding.rv,
                        { mAdapter.isHeader(it) },
                        { /*onClick Event*/ }
                )
        )
        binding.rv.addItemDecoration(StickyFooterItemDecoration())
        mAdapter.addFooter()
    }

    private fun initLv() {
        mVM.lvAddItem.observe(viewLifecycleOwner, Observer { item ->
            mAdapter.addItem(item)
        })
        mVM.lvAddHeader.observe(viewLifecycleOwner, Observer { header ->
            mAdapter.addItem(header)
        })
        mVM.lvClearItems.observe(viewLifecycleOwner, Observer { boolean ->
            if (boolean) mAdapter.clear()
        })
    }
}