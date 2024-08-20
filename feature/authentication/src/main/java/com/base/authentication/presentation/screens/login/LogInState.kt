package com.base.authentication.presentation.screens.login

import androidx.compose.runtime.Stable
import com.google.firebase.auth.FirebaseUser

@Stable
data class LoginState(
    val isLoading : Boolean = false,
    val data : FirebaseUser? = null,
    val error : String? = null
)