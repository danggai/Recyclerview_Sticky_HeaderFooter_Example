package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.example.recyclerview_sticky_headerfooter_example.BindingFragment
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.databinding.FragmentMainTabFirstBinding
import com.example.recyclerview_sticky_headerfooter_example.util.StickyHeaderItemDecoration
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainTabFirstFragment : BindingFragment<FragmentMainTabFirstBinding>() {

    companion object {
        val TAG: String = MainTabFirstFragment::class.java.simpleName
        fun newInstance() = MainTabFirstFragment()
    }

    private lateinit var mVM: MainTabViewModel
    private lateinit var mAdapter: MainTabAdapter

    @LayoutRes
    override fun getLayoutResId() = R.layout.fragment_main_tab_first

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
                        false,
                ) { mAdapter.isHeader(it) }
        )
    }

    private fun initLv() {
        mVM.lvSetItemList.observe(viewLifecycleOwner, Observer { list ->
            context?.let { _ ->
                binding.rv.apply {
                    if (adapter == null)
                        adapter = MainTabAdapter(mVM)
                    (adapter as MainTabAdapter).apply {
                        setItemList(list, false)
                    }
                }
            }
        })
        mVM.lvAddItem.observe(viewLifecycleOwner, Observer { item ->
            context?.let { _ ->
                binding.rv.apply {
                    if (adapter == null)
                        adapter = MainTabAdapter(mVM)
                    (adapter as MainTabAdapter).apply {
                        addItem(item)
                    }
                }
            }
        })
    }
}