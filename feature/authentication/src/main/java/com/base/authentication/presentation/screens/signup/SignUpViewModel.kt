package com.base.authentication.presentation.screens.signup

import androidx.lifecycle.viewModelScope
import com.base.authentication.data.model.AuthResult
import com.base.authentication.domain.use_cases.SignUpUseCase
import com.base.common.navigation.NavigationService
import com.base.common.presentation.StateAndEventViewModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase,
    private val navigator: NavigationService
) : StateAndEventViewModel<SignUpState, SignUpIntents>(initialState = SignUpState()) {

    override fun handleEvent(event: SignUpIntents) {
        when (event) {
            is SignUpIntents.SignUpUser -> {
                signUpUser(event.email, event.password)
            }
            is SignUpIntents.Dismiss -> {
                handleBack()
            }
        }
    }


    private fun signUpUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            signUpUseCase(email, password)
                .onStart {
                    updateUiState { copy(isLoading = true) }
                }
                .catch { exception ->
                    updateUiState { copy(error = exception.message, isLoading = false) }
                }
                .collect { signUpResult ->
                    when (signUpResult) {
                        is AuthResult.Success<*> -> {
                            updateUiState {
                                copy(
                                    data = signUpResult.data as FirebaseUser?,
                                    isLoading = false
                                )
                            }
                        }

                        is AuthResult.Error -> {
                            updateUiState { copy(error = signUpResult.message, isLoading = false) }
                        }

                    }

                }
        }
    }

    private fun handleBack() {
        navigator.goBack()
    }

}