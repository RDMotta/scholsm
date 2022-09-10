package com.rdm.scholsm.configuration

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
class R2dbcConfig {

    @Bean
    fun initializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
        val init = ConnectionFactoryInitializer()
        init.setConnectionFactory(connectionFactory)
        init.setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema-db.sql")))
        return init
    }
}