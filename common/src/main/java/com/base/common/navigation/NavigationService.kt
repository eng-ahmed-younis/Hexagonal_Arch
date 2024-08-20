package com.base.common.navigation

import androidx.navigation.NavOptionsBuilder

interface NavigationService {
    fun navigateTo(destination: String, navOptions: NavOptionsBuilder.() -> Unit = {})
    fun goBack()
}