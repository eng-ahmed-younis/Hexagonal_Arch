package com.base.hexagonal_arch.di

import com.base.authentication.data.repository.AuthRepositoryImpl
import com.base.authentication.domain.repository.AuthRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.lazyModule

val repositoryModule = lazyModule {

    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
}