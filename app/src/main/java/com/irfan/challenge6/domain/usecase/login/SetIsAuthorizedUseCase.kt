package com.irfan.challenge6.domain.usecase.login

import com.irfan.challenge6.data.UserRepository
import com.irfan.challenge6.data.source.local.entity.UserEntity
import javax.inject.Inject

class SetIsAuthorizedUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity, isAuthorizedState: Boolean) {
        return userRepository.setIsAuthorized(userEntity, isAuthorizedState)
    }
}