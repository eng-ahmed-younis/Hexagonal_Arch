package com.base.authentication.domain.repository

import com.base.authentication.data.model.AuthResult
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun loginWithEmailPassword(email: String, password: String): AuthResult

    suspend fun registerWithEmailPassword(email: String, password: String): AuthResult

    suspend fun signOut(): AuthResult

    suspend fun getCurrentUser(): AuthResult

    suspend fun sendResetPassword(email: String): Boolean
}