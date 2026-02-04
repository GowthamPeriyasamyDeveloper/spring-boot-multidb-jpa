package io.github.gowtham.spring_boot_multidb_jpa.service;

import io.github.gowtham.spring_boot_multidb_jpa.mysql.entity.MySqlUser;
import io.github.gowtham.spring_boot_multidb_jpa.mysql.repository.MySqlUserRepository;
import io.github.gowtham.spring_boot_multidb_jpa.postgres.entity.PostgresEmployee;
import io.github.gowtham.spring_boot_multidb_jpa.postgres.repository.PostgresEmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MultiDbService {

    private final MySqlUserRepository mysqlRepo;

    private final PostgresEmployeeRepository postgresRepo;

    public MultiDbService(MySqlUserRepository mysqlRepo, PostgresEmployeeRepository postgresRepo)
    {
        this.mysqlRepo = mysqlRepo;
        this.postgresRepo = postgresRepo;
    }

    @Transactional("mysqlTransactionManager")
    public MySqlUser saveUserToMySql(MySqlUser user)
    {
        return mysqlRepo.save(user);
    }

    @Transactional("postgresTransactionManager")
    public List<PostgresEmployee> fetchFromPostgres()
    {
        return postgresRepo.findAll();
    }

    @Transactional("postgresTransactionManager")
    public PostgresEmployee saveEmployeeToPostgres(PostgresEmployee employee)
    {
        return postgresRepo.save(employee);
    }

    @Transactional("mysqlTransactionManager")
    public List<MySqlUser> fetchFromMySQL()
    {
        return mysqlRepo.findAll();
    }
}
