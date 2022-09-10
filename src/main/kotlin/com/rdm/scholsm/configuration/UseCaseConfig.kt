package com.rdm.scholsm.configuration

import com.rdm.scholsm.core.repositories.UserRepository
import com.rdm.scholsm.core.usecases.CreateUserUseCase
import com.rdm.scholsm.core.usecases.GetUserByIdUseCase
import com.rdm.scholsm.core.usecases.impl.DefaultCreateUserUseCase
import com.rdm.scholsm.core.usecases.impl.DefaultGetUserByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig(private val userRepository: UserRepository) {

    @Bean
    fun createUserUseCase(): CreateUserUseCase {
        return DefaultCreateUserUseCase(userRepository)
    }

    @Bean
    fun getUserByIdUseCase(): GetUserByIdUseCase {
        return DefaultGetUserByIdUseCase(userRepository)
    }
}