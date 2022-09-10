package com.rdm.scholsm.datasource.transactional

import org.springframework.data.r2dbc.repository.R2dbcRepository
import com.rdm.scholsm.datasource.transactional.entities.UserEntity

interface UserR2dbcRepository : R2dbcRepository<UserEntity, Long> {
}