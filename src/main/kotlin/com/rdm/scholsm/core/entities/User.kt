package com.rdm.scholsm.core.entities

import com.rdm.scholsm.utils.GenID
import java.time.Instant

data class User(
    val id: Long,
    val name: String,
    val createdAt: Instant,
    val updatedAt: Instant
) {
    companion object {

        fun newUser(name: String): User {
            val id = GenID.nextId()
            val now = Instant.now()
            return User(
                id = id,
                name = name,
                createdAt = now,
                updatedAt = now
            )
        }
    }
}
