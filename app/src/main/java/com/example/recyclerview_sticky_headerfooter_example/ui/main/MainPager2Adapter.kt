package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_sticky_headerfooter_example.R

public class MainPager2Adapter() : RecyclerView.Adapter<MainPager2Adapter.ItemViewHolder>() {

    companion object {
        const val itemSize = 3

        const val TYPE_HEADER_ONLY = 0
        const val TYPE_FOOTER_ONLY = 1
        const val TYPE_BOTH = 2
    }

    class ItemViewHolder(
        layoutId: Int,
        parent: ViewGroup,
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return when (viewType) {
            TYPE_HEADER_ONLY -> {
                ItemViewHolder(R.layout.fragment_main_tab_first, parent)
            }
            TYPE_FOOTER_ONLY -> {
                ItemViewHolder(R.layout.fragment_main_tab_second, parent)
            }
            else -> {
                ItemViewHolder(R.layout.fragment_main_tab_third, parent)
            }
        }
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        when (holder.binding) {
//            is FragmentMainTabFirstBinding -> {
//                holder.binding.vm = viewModel
//            }
//            is FragmentMainTabSecondBinding -> {
//                holder.binding.vm = viewModel
//            }
//            is FragmentMainTabThirdBinding -> {
//                holder.binding.vm = viewModel
//            }
        }
    }

    override fun getItemCount(): Int {
        return itemSize
    }


}