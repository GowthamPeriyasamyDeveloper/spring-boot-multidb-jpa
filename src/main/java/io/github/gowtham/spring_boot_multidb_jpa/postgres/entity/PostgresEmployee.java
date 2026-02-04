package io.github.gowtham.spring_boot_multidb_jpa.postgres.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class PostgresEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
