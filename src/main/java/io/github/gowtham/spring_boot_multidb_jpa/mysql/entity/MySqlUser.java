package io.github.gowtham.spring_boot_multidb_jpa.mysql.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class MySqlUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
}
