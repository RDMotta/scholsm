package com.rdm.scholsm.transport.rest

import com.rdm.scholsm.core.usecases.CreateUserUseCase
import com.rdm.scholsm.core.usecases.GetUserByIdUseCase
import com.rdm.scholsm.core.usecases.command.NewUserCommand
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class UserWebAdapter(
        private val createUserUseCase: CreateUserUseCase,
        private val getUserByIdUseCase: GetUserByIdUseCase
) {
    suspend fun create(req: ServerRequest): ServerResponse {
        val aCommand = req.awaitBody(NewUserCommand::class)
        return  ServerResponse.ok()
            .bodyValueAndAwait(createUserUseCase.execute(aCommand))
    }

    suspend fun getById(req: ServerRequest): ServerResponse {
        val id  = req.pathVariable("userId").toLong()
        return getUserByIdUseCase.execute(id)?.let {
            ServerResponse.ok().bodyValueAndAwait(it)
        } ?: ServerResponse.notFound().buildAndAwait()
    }
}