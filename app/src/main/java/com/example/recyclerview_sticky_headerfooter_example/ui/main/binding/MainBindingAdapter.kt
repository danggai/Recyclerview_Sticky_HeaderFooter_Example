package com.example.recyclerview_sticky_headerfooter_example.ui.main.binding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview_sticky_headerfooter_example.ui.main.MainTabAdapter
import com.example.recyclerview_sticky_headerfooter_example.ui.main.MainTabViewModel

import kotlin.jvm.JvmStatic;

object MainBindingAdapter {
    @BindingAdapter(value = ["items", "viewModel"], requireAll = true)
    @JvmStatic fun bindItemList(
            view:RecyclerView,
            items: MutableList<Any>,
            vm: MainTabViewModel
    ) {
        view.adapter?.run {
            if (this is MainTabAdapter) {
                this.setItemList(items)
            }
        } ?: run {
            MainTabAdapter(vm).apply {
                view.adapter = this
                this.setItemList(items)
            }
        }
    }
}
