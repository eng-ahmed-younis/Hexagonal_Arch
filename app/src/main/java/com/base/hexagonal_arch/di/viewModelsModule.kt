package com.base.hexagonal_arch.di

import com.base.authentication.presentation.screens.login.LogInViewModel
import com.base.authentication.presentation.screens.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.lazyModule

val viewModelModule = lazyModule {
    viewModel { SignUpViewModel(get(), get()) }
    viewModel { LogInViewModel(get(), get()) }

}