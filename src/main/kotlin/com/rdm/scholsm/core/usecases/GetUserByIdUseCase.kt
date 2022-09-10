package com.rdm.scholsm.core.usecases

import com.rdm.scholsm.core.entities.User

interface GetUserByIdUseCase {
    suspend fun execute(id: Long): User?
}