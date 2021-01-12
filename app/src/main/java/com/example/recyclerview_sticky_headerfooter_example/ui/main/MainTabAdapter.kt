package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListFooter
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListHeader
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListItem
import com.example.recyclerview_sticky_headerfooter_example.databinding.ItemListFooterBinding
import com.example.recyclerview_sticky_headerfooter_example.databinding.ItemListHeaderBinding
import com.example.recyclerview_sticky_headerfooter_example.databinding.ItemListItemBinding


class MainTabAdapter(val viewModel: MainTabViewModel) : RecyclerView.Adapter<MainTabAdapter.ItemViewHolder>() {

    companion object {
        const val itemSize = 3

        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
        const val TYPE_FOOTER = 2
    }

    private var mDataSet = mutableListOf<Any>()
    val _mDataSet = mDataSet

    fun clear() {
        if (mDataSet.size > 0 && mDataSet[mDataSet.size-1] is ListFooter) {
            mDataSet.clear()
            mDataSet.add(ListFooter())
        } else {
            mDataSet.clear()
        }
        notifyDataSetChanged()
    }

    fun setItemList(_itemList: MutableList<Any>) {
        mDataSet.clear()
        mDataSet.addAll(_itemList)
        notifyDataSetChanged()
    }

    fun addItem(item: Any) {
        if (mDataSet.size > 0 && mDataSet[mDataSet.size-1] is ListFooter) {
            mDataSet.add(mDataSet.size-1, item)
            notifyItemInserted(mDataSet.size-1)
        } else {
            mDataSet.add(item)
            notifyItemInserted(mDataSet.size)
        }
    }

    fun addFooter() {
        mDataSet.add(ListFooter())
        notifyItemInserted(mDataSet.size)
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
            TYPE_HEADER -> {
                ItemViewHolder(R.layout.item_list_header, parent)
            }
            TYPE_ITEM -> {
                ItemViewHolder(R.layout.item_list_item, parent)
            }
            else -> {
                ItemViewHolder(R.layout.item_list_footer, parent)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (mDataSet[position]) {
            is ListHeader -> TYPE_HEADER
            is ListItem -> TYPE_ITEM
            else -> TYPE_FOOTER
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        when (holder.binding) {
            is ItemListHeaderBinding -> {
                holder.binding.vm = viewModel
                val data : ListHeader = mDataSet[position] as ListHeader
                holder.binding.tvHeader.text = data.saparator
            }
            is ItemListItemBinding -> {
                holder.binding.vm = viewModel
                val data : ListItem = mDataSet[position] as ListItem
                holder.binding.tvName.text = data.name
                holder.binding.tvPhone.text = data.phone
//                holder.binding.ivProfile = data.
            }
            is ItemListFooterBinding -> {
                holder.binding.vm = viewModel
            }
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    fun isHeader(position: Int): Boolean {
        return when (mDataSet[position]) {
            is ListHeader -> true
            else -> false
        }
    }
}