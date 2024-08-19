package com.base.authentication.data.repository

import com.base.authentication.domain.repository.AuthRepository
import com.base.authentication.domain.repository.Authenticator
import com.google.firebase.auth.FirebaseUser

class AuthRepositoryImpl(private val authenticator: Authenticator) : AuthRepository {

    override suspend fun loginWithEmailPassword(email: String, password: String): FirebaseUser? =
        authenticator.loginWithEmailPassword(email, password)

    override suspend fun registerWithEmailPassword(email: String, password: String): FirebaseUser? =
        authenticator.registerWithEmailPassword(email, password)

    override fun signOut(): FirebaseUser? =
        authenticator.signOut()

    override fun getCurrentUser(): FirebaseUser? =
        authenticator.getUser()

    override suspend fun sendResetPassword(email: String): Boolean {
        authenticator.sendPasswordReset(email)
        return true
    }

}