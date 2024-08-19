package com.base.hexagonal_arch

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform.startKoin

class HexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    private fun main() {
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@HexApplication)
            // Load modules
            //modules(appModule)
        }
    }
}