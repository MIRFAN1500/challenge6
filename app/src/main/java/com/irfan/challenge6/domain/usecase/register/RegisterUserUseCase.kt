package com.irfan.challenge6.domain.usecase.register

import com.irfan.challenge6.data.UserRepository
import com.irfan.challenge6.data.source.local.entity.UserEntity
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity) {
        return userRepository.insertUser(userEntity)
    }
}