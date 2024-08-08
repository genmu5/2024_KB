package com.example.kb.config.dbConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.kb.entity.django",
        entityManagerFactoryRef = "djangodbEntityManagerFactory",
        transactionManagerRef = "djangodbTransactionManager"
)
public class DjangoDbJpaConfig {
}
