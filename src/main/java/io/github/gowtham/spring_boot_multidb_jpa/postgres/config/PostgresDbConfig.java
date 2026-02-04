package io.github.gowtham.spring_boot_multidb_jpa.postgres.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "io.github.gowtham.spring_boot_multidb_jpa.postgres.repository",
        entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
        transactionManagerRef = "postgresTransactionManager"
)
public class PostgresDbConfig
{

    @Bean
    @ConfigurationProperties(prefix = "postgres.datasource")
    public HikariDataSource postgresDataSource()
    {
        return new HikariDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactoryBean(EntityManagerFactoryBuilder emf)
    {
        Map<String, Object> jpaProps = new HashMap<>();
        jpaProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        return emf
                .dataSource( postgresDataSource() )
                .packages("io.github.gowtham.spring_boot_multidb_jpa.postgres.entity")
                .persistenceUnit("postgresPU")
                .properties(jpaProps)
                .build();
    }

    @Bean
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactoryBean") EntityManagerFactory emf1)
    {
       return new JpaTransactionManager(emf1);
    }

}
