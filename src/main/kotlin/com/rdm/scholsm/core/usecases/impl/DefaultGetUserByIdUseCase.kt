package com.rdm.scholsm.core.usecases.impl

import com.rdm.scholsm.core.entities.User
import com.rdm.scholsm.core.repositories.UserRepository
import com.rdm.scholsm.core.usecases.GetUserByIdUseCase

class DefaultGetUserByIdUseCase(private val userRepository: UserRepository): GetUserByIdUseCase {
    override suspend fun execute(id: Long): User? {
        return userRepository.getById(id)
    }
}