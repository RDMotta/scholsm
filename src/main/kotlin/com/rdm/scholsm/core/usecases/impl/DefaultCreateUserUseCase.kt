package com.rdm.scholsm.core.usecases.impl

import com.rdm.scholsm.core.entities.User
import com.rdm.scholsm.core.repositories.UserRepository
import com.rdm.scholsm.core.usecases.CreateUserUseCase
import com.rdm.scholsm.core.usecases.command.NewUserCommand

class DefaultCreateUserUseCase(private val userRepository: UserRepository): CreateUserUseCase {

    override suspend fun execute(command: NewUserCommand): User {
        val (name) = command
        val user = User.newUser(name = name)
        userRepository.create(user)
        return user
    }
}