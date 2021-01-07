package com.example.recyclerview_sticky_headerfooter_example

import android.app.Application
import com.example.recyclerview_sticky_headerfooter_example.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(ViewModelModule)
        }
    }

}