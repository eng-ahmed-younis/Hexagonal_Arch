package com.base.authentication.domain.use_cases

import com.base.authentication.domain.repository.AuthRepository
import kotlinx.coroutines.flow.flow

class SignUpUseCase (
    private val authRepository: AuthRepository
){
    operator fun invoke(email: String, password: String) = flow {
        emit(authRepository.registerWithEmailPassword(email, password))
    }
}