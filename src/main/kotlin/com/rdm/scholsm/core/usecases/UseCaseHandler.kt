package com.rdm.scholsm.core.usecases

interface Command<T>

interface UseCaseHandler<T: Command<T>, R> {
   suspend fun execute(command: T): R
}