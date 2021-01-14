package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListHeader
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListItem

class MainTabViewModel : ViewModel() {

    var itemCnt = MutableLiveData<Int>(0)
    var headerCnt = MutableLiveData<Int>(0)

    var lvAddItem = MutableLiveData<Any>()
    var lvSetItemList = MutableLiveData<MutableList<Any>>()

    private var itemList = mutableListOf<Any>()
    val _itemList = itemList

    fun onClickBtn(view: View) {
        when (view.id) {
            R.id.tv_btn1 -> {
                Log.d("btn", "add header")
                itemList.add(itemList.size, ListHeader("${headerCnt.value}"))
                lvSetItemList.value = itemList
                headerCnt.value = headerCnt.value?.plus(1)
            }
            R.id.tv_btn2 -> {
                Log.d("btn", "add item")
                itemList.add(itemList.size, ListItem("${itemCnt.value}","010-0000-0000","zz","zz"))
                lvSetItemList.value = itemList
                itemCnt.value = itemCnt.value?.plus(1)
            }
            R.id.tv_btn3 -> {
                Log.d("btn", "clear items")
                itemList.clear()
                itemCnt.value = 0
                headerCnt.value = 0
            }
        }
    }
}