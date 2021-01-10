package com.example.recyclerview_sticky_headerfooter_example.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview_sticky_headerfooter_example.R
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListHeader
import com.example.recyclerview_sticky_headerfooter_example.data.local.common.ListItem

class MainTabViewModel : ViewModel() {

    var addItem = MutableLiveData<ListItem>()
    var addHeader = MutableLiveData<ListHeader>()

    fun onClickBtn(view: View) {
        when (view.id) {
            R.id.tv_btn1 -> {
                Log.d("btn", "add header")
                addHeader.value = ListHeader("Zz")
            }
            R.id.tv_btn2 -> {
                Log.d("btn", "add item")
                addItem.value = ListItem("Zz","zz","zz","zz")
            }
        }
    }

}