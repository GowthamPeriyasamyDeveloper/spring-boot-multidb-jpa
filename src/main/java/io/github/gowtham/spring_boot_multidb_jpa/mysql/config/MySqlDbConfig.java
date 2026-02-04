package io.github.gowtham.spring_boot_multidb_jpa.mysql.config;

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
        basePackages = "io.github.gowtham.spring_boot_multidb_jpa.mysql.repository",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MySqlDbConfig
{
    @Bean
    @ConfigurationProperties(prefix = "mysql.datasource")
    public HikariDataSource mysqlDataSource()
    {
        return new HikariDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder)
    {
        Map<String, Object> jpaProps = new HashMap<>();
        jpaProps.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

      return entityManagerFactoryBuilder
              .dataSource(mysqlDataSource())
              .packages("io.github.gowtham.spring_boot_multidb_jpa.mysql.entity")
              .persistenceUnit("mysqlPU")
              .properties(jpaProps)
              .build();
    }

    @Bean
    public PlatformTransactionManager mysqlTransactionManager( @Qualifier("mysqlEntityManagerFactory")EntityManagerFactory emf )
    {
        return new JpaTransactionManager(emf);
    }
}
