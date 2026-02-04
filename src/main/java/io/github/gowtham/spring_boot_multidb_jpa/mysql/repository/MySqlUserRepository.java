package io.github.gowtham.spring_boot_multidb_jpa.mysql.repository;

import io.github.gowtham.spring_boot_multidb_jpa.mysql.entity.MySqlUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlUserRepository extends JpaRepository<MySqlUser, Long>
{

}
