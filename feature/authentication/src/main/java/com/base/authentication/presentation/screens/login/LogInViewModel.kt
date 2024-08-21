package com.base.authentication.presentation.screens.login

import androidx.lifecycle.viewModelScope
import com.base.authentication.data.model.AuthResult
import com.base.authentication.domain.use_cases.LogInUseCase
import com.base.common.navigation.NavigationService
import com.base.common.presentation.StateAndEventViewModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class LogInViewModel(
    private val logInUseCase: LogInUseCase,
    private val navigator: NavigationService
) : StateAndEventViewModel<LoginState, LoginIntents>(initialState = LoginState()) {


    private fun signUpUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            logInUseCase(email, password)
                .onStart {
                    updateUiState { copy(isLoading = true) }
                }
                .catch { exception ->
                    updateUiState { copy(error = exception.message, isLoading = false) }
                }
                .collect { loginResult ->
                    when (loginResult) {
                        is AuthResult.Success<*> -> {
                            updateUiState {
                                copy(
                                    data = loginResult.data as FirebaseUser?,
                                    isLoading = false
                                )
                            }
                        }

                        is AuthResult.Error -> {
                            updateUiState { copy(error = loginResult.message, isLoading = false) }
                        }

                    }

                }
        }
    }

    private fun handleBack() {
        navigator.goBack()
    }

    override fun handleEvent(event: LoginIntents) {
        when (event) {
            is LoginIntents.LoginUser -> {
                signUpUser(event.email, event.password)
            }

            is LoginIntents.Dismiss -> {
                handleBack()
            }
        }
    }

}