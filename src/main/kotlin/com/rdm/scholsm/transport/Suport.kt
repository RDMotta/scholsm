package com.rdm.scholsm.transport

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

internal typealias HandlerFn = suspend (ServerRequest) -> ServerResponse

internal typealias FilterFn = suspend (ServerRequest, HandlerFn) -> ServerResponse

val ensureUserId: FilterFn = {
    req, next -> if (req.queryParam("userId").isEmpty) {
        ServerResponse.status(HttpStatus.UNAUTHORIZED).bodyValueAndAwait("Parameter 'userId' is required")
    } else {
        next(req)
    }
}