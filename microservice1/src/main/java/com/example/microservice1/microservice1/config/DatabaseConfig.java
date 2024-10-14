package com.example.microservice1.microservice1.config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

@Configuration
@Slf4j
public class DatabaseConfig {

    @Bean
    public PostgresqlConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .port(5432)
                .database("microservice1")
                .username("postgres")
                .password("Hrhk@4321")
                .build();

        return new PostgresqlConnectionFactory(config);
    }

    @Bean
    public ConnectionPool connectionPool(PostgresqlConnectionFactory connectionFactory) {
        log.info("Connection pool initialized.");
        ConnectionPoolConfiguration poolConfig = ConnectionPoolConfiguration.builder(connectionFactory)
                .maxSize(20)
                .initialSize(5)
                .build();
        return new ConnectionPool(poolConfig);
    }
    @Bean
    public R2dbcEntityOperations r2dbcEntityTemplate(ConnectionPool connectionPool) {
        return new R2dbcEntityTemplate(connectionPool);
    }
}

