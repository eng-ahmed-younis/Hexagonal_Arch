package com.base.hexagonal_arch.navigation.graphs

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.base.authentication.presentation.screens.login.LogInScreen
import com.base.authentication.presentation.screens.login.LogInViewModel
import com.base.authentication.presentation.screens.signup.SignUpScreen
import com.base.authentication.presentation.screens.signup.SignUpViewModel
import com.base.hexagonal_arch.navigation.AppScreen
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.authNavGraph() {

    navigation(
        startDestination = AppScreen.AuthGraph.LoginScreen.route,
        route = AppScreen.AuthGraph.route
    ){
        composable(AppScreen.AuthGraph.LoginScreen.route){
           val loginViewModel = koinViewModel<LogInViewModel>()
            LogInScreen(
                state = loginViewModel.state.collectAsStateWithLifecycle().value,
                sendEvent = loginViewModel::onEvent
            )
        }
        composable(AppScreen.AuthGraph.SignupScreen.route){
            val signUpViewModel = koinViewModel<SignUpViewModel>()
            SignUpScreen(
                state = signUpViewModel.state.collectAsStateWithLifecycle().value,
                sendEvent = signUpViewModel::onEvent
            )

        }

    }
}