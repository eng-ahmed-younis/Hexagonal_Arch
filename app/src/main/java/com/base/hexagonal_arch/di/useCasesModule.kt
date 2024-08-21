package com.base.hexagonal_arch.di

import com.base.authentication.domain.use_cases.LogInUseCase
import com.base.authentication.domain.use_cases.SignUpUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.lazyModule

val useCasesModule  = lazyModule {
    factoryOf(::LogInUseCase)
    factoryOf(::SignUpUseCase)

}
