package com.base.authentication.presentation.screens.login

import com.base.authentication.presentation.screens.signup.SignUpIntents

sealed interface LoginIntents {
    data class LoginUser(val email: String, val password: String) : LoginIntents
    data object Dismiss : LoginIntents

}



/** different between sealed and enum each member of sealed class is individual instance
 * and have custom behavior if sealed class take parameter in constructor give parameter
 * and have other custom properties
 *
 *
 *
 *
 * enum each item is constant not have own behavior if enum take parameter give parameter only
 *
 *
 *
 *
 * sealed interface not have constructor
 * */