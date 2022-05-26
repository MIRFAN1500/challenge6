package com.irfan.challenge6.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irfan.challenge6.data.source.local.entity.UserEntity
import com.irfan.challenge6.domain.usecase.profile.DeleteAllMovieUseCase
import com.irfan.challenge6.domain.usecase.profile.DeleteAllUserUseCase
import com.irfan.challenge6.domain.usecase.profile.GetUserUseCase
import com.irfan.challenge6.domain.usecase.profile.UpdateUserUseCase
import kotlinx.coroutines.launch

class ProfileViewModel(
    val getUserUseCase: GetUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val deleteAllUserUseCase: DeleteAllUserUseCase,
    val deleteAllMovieUseCase: DeleteAllMovieUseCase
) : ViewModel() {

    fun getUser(email:String) = getUserUseCase(email)

    fun updateUser(userEntity: UserEntity) {
        viewModelScope.launch {
            updateUserUseCase(userEntity)
        }
    }

    fun deleteAllMovie() {
        viewModelScope.launch {
            deleteAllMovieUseCase()
        }
    }

    fun deleteAllUser() {
        viewModelScope.launch {
            deleteAllUserUseCase()
        }
    }
}