package com.base.hexagonal_arch.di

import com.base.authentication.data.remote.FirebaseAuthenticator
import com.base.authentication.domain.repository.Authenticator
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.bind
import org.koin.dsl.lazyModule

val  appModule  = lazyModule {

  single{ FirebaseAuth.getInstance()}
/*  single { FirebaseAuthenticator(get()) } withOptions {
    bind<Authenticator>()
    createdAtStart()
  }*/
 /* singleOf(::FirebaseAuthenticator) withOptions {
    bind<Authenticator>()
    createdAtStart()
  }*/
  singleOf(::FirebaseAuthenticator) bind Authenticator::class

}