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
    var lvClearItemList = MutableLiveData<Boolean>(false)

    private var itemList = mutableListOf<Any>()
    val _itemList = itemList

    init {
        initItemList()
    }

    fun onClickBtn(view: View) {
        when (view.id) {
            R.id.tv_btn1 -> {
                Log.d("btn", "add header")
                addHeader()
            }
            R.id.tv_btn2 -> {
                Log.d("btn", "add item")
                addItem()
            }
            R.id.tv_btn3 -> {
                Log.d("btn", "clear items")
                clearItemList()
            }
        }
    }

    private fun addHeader() {
        itemList.add(itemList.size, ListHeader("${headerCnt.value}"))
        lvSetItemList.value = itemList
        headerCnt.value = headerCnt.value?.plus(1)
    }

    private fun addItem() {
        itemList.add(itemList.size, ListItem("${itemCnt.value}","010-0000-0000","zz","zz"))
        lvSetItemList.value = itemList
        itemCnt.value = itemCnt.value?.plus(1)
    }

    private fun clearItemList() {
        lvClearItemList.value = true
        itemList.clear()
        itemCnt.value = 0
        headerCnt.value = 0
    }

    private fun initItemList() {
        itemList.clear()
        itemList.add(itemList.size, ListHeader("0"))
        itemList.add(itemList.size, ListItem("0","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("1","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("2","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListHeader("1"))
        itemList.add(itemList.size, ListItem("3","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("4","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("5","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("6","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListHeader("2"))
        itemList.add(itemList.size, ListItem("7","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("8","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("9","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("10","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("11","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListHeader("3"))
        itemList.add(itemList.size, ListItem("12","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("13","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("14","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("15","010-0000-0000","zz","zz"))
        itemList.add(itemList.size, ListItem("16","010-0000-0000","zz","zz"))
        lvSetItemList.value = itemList
    }
}