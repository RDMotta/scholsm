package com.rdm.scholsm.datasource.transactional.entities

import com.rdm.scholsm.core.entities.User
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table(name = "users")
data class UserEntity(
    @Id val id: Long,
    @Column(value = "name") val name: String,
    @Column(value = "created_at") val createdAt: Instant,
    @Column(value = "updated_at") val updatedAt: Instant
) {

    companion object {
        fun from(user: User) = UserEntity(
            id = user.id,
            name = user.name,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }
}