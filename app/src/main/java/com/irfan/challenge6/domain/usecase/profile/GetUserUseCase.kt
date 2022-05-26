package com.irfan.challenge6.domain.usecase.profile

import androidx.lifecycle.LiveData
import com.irfan.challenge6.data.UserRepository
import com.irfan.challenge6.data.source.local.entity.UserEntity
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(email: String): LiveData<UserEntity?> {
        return userRepository.getUser(email)
    }
}