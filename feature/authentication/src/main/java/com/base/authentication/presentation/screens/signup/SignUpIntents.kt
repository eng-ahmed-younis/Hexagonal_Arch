package com.base.authentication.presentation.screens.signup

sealed interface SignUpIntents {
    data class SignUpUser(val email: String, val password: String) : SignUpIntents
    data object Dismiss : SignUpIntents

}