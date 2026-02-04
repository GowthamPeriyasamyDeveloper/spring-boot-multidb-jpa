package io.github.gowtham.spring_boot_multidb_jpa.postgres.repository;

import io.github.gowtham.spring_boot_multidb_jpa.postgres.entity.PostgresEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresEmployeeRepository extends JpaRepository<PostgresEmployee, Long>
{
}
