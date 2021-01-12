package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListHeader
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListItem

class MainTabViewModel : ViewModel() {

    var lvAddItem = MutableLiveData<ListItem>()
    var lvAddHeader = MutableLiveData<ListHeader>()
    var lvClearItems = MutableLiveData<Boolean>()

    var itemCnt = MutableLiveData<Int>(0)
    var headerCnt = MutableLiveData<Int>(0)

    fun onClickBtn(view: View) {
        when (view.id) {
            R.id.tv_btn1 -> {
                Log.d("btn", "add header")
                lvAddHeader.value = ListHeader("${headerCnt.value}")
                headerCnt.value = headerCnt.value?.plus(1)
            }
            R.id.tv_btn2 -> {
                Log.d("btn", "add item")
                lvAddItem.value = ListItem("${itemCnt.value}","010-0000-0000","zz","zz")
                itemCnt.value = itemCnt.value?.plus(1)
            }
            R.id.tv_btn3 -> {
                Log.d("btn", "clear items")
                itemCnt.value = 0
                headerCnt.value = 0
                lvClearItems.value = true
            }
        }
    }

}