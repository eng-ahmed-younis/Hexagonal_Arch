package com.base.authentication.data.model

sealed interface AuthResult {
    data class Success<out T>(val data: T? = null) : AuthResult
    data class Error(val message: String) : AuthResult
}