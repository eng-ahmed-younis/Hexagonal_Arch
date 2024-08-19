package com.base.authentication.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun loginWithEmailPassword(email: String, password: String): FirebaseUser?

    suspend fun registerWithEmailPassword(email: String, password: String): FirebaseUser?

    fun signOut(): FirebaseUser?

    fun getCurrentUser(): FirebaseUser?

    suspend fun sendResetPassword(email: String): Boolean
}