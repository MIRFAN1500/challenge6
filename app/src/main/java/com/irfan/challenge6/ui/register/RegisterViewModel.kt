package com.irfan.challenge6.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irfan.challenge6.data.source.local.entity.UserEntity
import com.irfan.challenge6.domain.usecase.register.RegisterUserUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {

    fun registerUser(userEntity: UserEntity) {
        viewModelScope.launch {
            registerUserUseCase(userEntity)
        }
    }
}