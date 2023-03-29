package com.example.mostgenericappwithapis.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
@Profile("test")
public class FlywayConfig {

    private final Environment env;

    public FlywayConfig(final Environment env) {
        this.env = env;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        String POSTGRES_VERSION = "postgres:11.1";
        PostgreSQLContainer database;

        database = new PostgreSQLContainer(POSTGRES_VERSION);
        database.start();
        return new Flyway(Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(
                        database.getJdbcUrl(),
                        database.getUsername(),
                        database.getPassword())
                .locations(env.getRequiredProperty("spring.flyway.locations"))
        );
    }
}
