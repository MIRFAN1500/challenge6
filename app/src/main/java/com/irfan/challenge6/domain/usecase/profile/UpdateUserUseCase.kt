package com.irfan.challenge6.domain.usecase.profile

import com.irfan.challenge6.data.UserRepository
import com.irfan.challenge6.data.source.local.entity.UserEntity
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity) {
        return userRepository.updateUser(userEntity)
    }
}