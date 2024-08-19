package com.base.hexagonal_arch.di

import com.base.authentication.domain.repository.Authenticator
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.lazyModule
import org.koin.dsl.module

val  appModule  = lazyModule {

  single{ FirebaseAuth.getInstance()}
  singleOf(::FirebaseAuthenticator){ bind<SimpleService>() }



}