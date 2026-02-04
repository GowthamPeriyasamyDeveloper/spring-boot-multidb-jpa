package io.github.gowtham.spring_boot_multidb_jpa.mysql.dto;

public class CreateUserRequest {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
}
