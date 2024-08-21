package com.base.hexagonal_arch.di

import android.system.Os.bind
import com.base.common.navigation.NavigationService
import com.base.hexagonal_arch.navigation.Navigator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.lazyModule

val appNavigation = lazyModule {
    singleOf(::Navigator) bind NavigationService::class
}