package com.irfan.challenge6.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irfan.challenge6.data.source.local.entity.UserEntity
import com.irfan.challenge6.domain.usecase.login.LoginUseCase
import com.irfan.challenge6.domain.usecase.login.SetIsAuthorizedUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    val loginUseCase: LoginUseCase,
    val setIsAuthorizedUseCase: SetIsAuthorizedUseCase
) : ViewModel() {

    fun doLogin(email: String, password: String) = loginUseCase(email, password)

    fun setIsAuthorized(userEntity: UserEntity, isAuthorizedState: Boolean) {
        viewModelScope.launch {
            setIsAuthorizedUseCase(userEntity, isAuthorizedState)
        }
    }
}