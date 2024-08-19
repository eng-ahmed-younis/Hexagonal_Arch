package com.base.authentication.data.model

sealed class AuthResult<out T> {
    data class Success<out T>(val data: T? = null) : AuthResult<T>()
    data class Error(val message: String) : AuthResult<Nothing>()
    data object Loading : AuthResult<Nothing>()
}