package com.rdm.scholsm.transport.rest

import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

interface UserResource {
    fun userRoutes(): RouterFunction<ServerResponse>
}