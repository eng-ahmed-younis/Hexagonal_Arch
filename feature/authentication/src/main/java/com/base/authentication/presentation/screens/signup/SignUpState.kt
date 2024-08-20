package com.base.authentication.presentation.screens.signup

import androidx.compose.runtime.Stable
import com.google.firebase.auth.FirebaseUser

@Stable
data class SignUpState(
    val isLoading : Boolean = false,
    val data : FirebaseUser? = null,
    val error : String? = null
)
