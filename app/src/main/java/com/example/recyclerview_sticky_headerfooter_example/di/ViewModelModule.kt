package com.example.recyclerview_sticky_headerfooter_example.di

import com.example.recyclerview_sticky_headerfooter_example.ui.main.MainTabViewModel
import com.example.recyclerview_sticky_headerfooter_example.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { MainTabViewModel() }
}