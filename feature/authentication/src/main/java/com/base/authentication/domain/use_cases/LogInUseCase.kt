package com.base.authentication.domain.use_cases

import com.base.authentication.data.model.AuthResult
import com.base.authentication.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LogInUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(email: String, password: String) =  flow {
        emit(authRepository.loginWithEmailPassword(email, password))
    }
}