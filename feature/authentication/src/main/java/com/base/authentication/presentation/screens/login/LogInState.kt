package com.base.authentication.presentation.screens.login

data class LogInState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
