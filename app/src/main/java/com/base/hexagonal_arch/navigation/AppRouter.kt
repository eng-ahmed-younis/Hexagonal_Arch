package com.base.hexagonal_arch.navigation

import com.base.common.navigation.Routes

sealed class AppScreen(val route: String){

    data object AuthGraph: AppScreen(route = Routes.AUTH_GRAPH){
        data object LoginScreen: AppScreen(route = Routes.LOGIN_SCREEN)
        data object SignupScreen: AppScreen(route = Routes.SIGNUP_SCREEN)
    }

    data object MainGraph: AppScreen(route = Routes.MAIN_GRAPH){
        data object HomeScreen: AppScreen(route = Routes.HOME_SCREEN)
        data object ProfileScreen: AppScreen(route = Routes.PROFILE_SCREEN)
    }
}