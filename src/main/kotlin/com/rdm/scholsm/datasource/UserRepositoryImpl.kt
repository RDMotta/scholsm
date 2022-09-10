package com.rdm.scholsm.datasource

import com.rdm.scholsm.core.entities.User
import com.rdm.scholsm.core.repositories.UserRepository
import com.rdm.scholsm.datasource.transactional.UserR2dbcRepository
import com.rdm.scholsm.datasource.transactional.entities.UserEntity
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserRepositoryImpl(
    private val userRepository: UserR2dbcRepository
    ) : UserRepository {

    @Transactional
    override suspend fun create(user: User): User {
        val entityUser = this.userRepository.save(UserEntity.from(user)).awaitFirst()
        return toOrigin(entityUser)
    }

    override suspend fun getById(id: Long): User? {
        val user = this.userRepository.findById(id).toFuture().get()

        if (user != null) return toOrigin(user)
        return null
    }

    private fun toOrigin(entity: UserEntity) = User (
        id = entity.id,
        name = entity.name,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )
}