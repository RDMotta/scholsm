package com.rdm.scholsm.transport

import com.rdm.scholsm.transport.rest.UserResource
import com.rdm.scholsm.transport.rest.UserWebAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class APIUserRouter(private val userHandler: UserWebAdapter): UserResource {

    @Bean
    fun rootRouter() = coRouter {
        add(userRoutes())
    }

    override fun userRoutes() = coRouter {
        path("/users").nest{
            GET("/{userId}", userHandler::getById)
            POST("", userHandler::create)
        }
    }
}
