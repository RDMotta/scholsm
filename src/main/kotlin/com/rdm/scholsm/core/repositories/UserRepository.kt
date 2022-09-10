package com.rdm.scholsm.core.repositories

import com.rdm.scholsm.core.entities.User

interface UserRepository {
    suspend fun create(user: User): User
    suspend fun getById(id: Long): User?
}