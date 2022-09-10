package com.rdm.scholsm.core.usecases

import com.rdm.scholsm.core.entities.User
import com.rdm.scholsm.core.usecases.command.NewUserCommand

interface CreateUserUseCase{
    suspend fun execute(command: NewUserCommand): User
}