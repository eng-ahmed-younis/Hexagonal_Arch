package com.base.authentication.data.repository

import com.base.authentication.data.model.AuthResult
import com.base.authentication.domain.repository.AuthRepository
import com.base.authentication.domain.repository.Authenticator
import com.google.firebase.auth.FirebaseUser

class AuthRepositoryImpl(private val authenticator: Authenticator) : AuthRepository {

    override suspend fun loginWithEmailPassword(email: String, password: String): AuthResult {
        return try {
            val data = authenticator.loginWithEmailPassword(email, password)
            AuthResult.Success(data)
        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "Unknown error")
        }
    }


    override suspend fun registerWithEmailPassword(email: String, password: String): AuthResult {
        return try {
            val data = authenticator.registerWithEmailPassword(email, password)
            AuthResult.Success(data)
        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun signOut(): AuthResult {
        return try {
            val data = authenticator.signOut()
            AuthResult.Success(data)
        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun getCurrentUser(): AuthResult {
        return try {
            val data = authenticator.getUser()
            AuthResult.Success(data)
        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun sendResetPassword(email: String): Boolean {
        authenticator.sendPasswordReset(email)
        return true
    }

}