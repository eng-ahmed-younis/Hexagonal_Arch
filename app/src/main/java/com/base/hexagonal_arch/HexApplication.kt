package com.base.hexagonal_arch

import android.app.Application
import com.base.hexagonal_arch.di.appModule
import com.base.hexagonal_arch.di.appNavigation
import com.base.hexagonal_arch.di.repositoryModule
import com.base.hexagonal_arch.di.useCasesModule
import com.base.hexagonal_arch.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.lazyModules
import org.koin.mp.KoinPlatform.startKoin

class HexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            // Log Koin into Android logger
            androidLogger()

            // Reference Android context
            androidContext(this@HexApplication)
            // Load modules
            //modules(appModule)

            lazyModules(
                appModule,
                viewModelModule,
                useCasesModule,
                repositoryModule,
                appNavigation
            )
        }
    }
}