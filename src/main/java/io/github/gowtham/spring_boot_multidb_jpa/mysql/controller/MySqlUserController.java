package io.github.gowtham.spring_boot_multidb_jpa.mysql.controller;

import io.github.gowtham.spring_boot_multidb_jpa.mysql.dto.CreateUserRequest;
import io.github.gowtham.spring_boot_multidb_jpa.mysql.entity.MySqlUser;
import io.github.gowtham.spring_boot_multidb_jpa.service.MultiDbService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mysql/users")
public class MySqlUserController {

    private final MultiDbService multiDbService;

    public MySqlUserController(MultiDbService multiDbService) {
        this.multiDbService = multiDbService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody CreateUserRequest request) {

        MySqlUser user = new MySqlUser();
        user.setUsername(request.getUsername());

        MySqlUser savedUser = multiDbService.saveUserToMySql(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping
    public ResponseEntity<?> getMySQLEmployeeDetails()
    {
        return ResponseEntity.ok(multiDbService.fetchFromMySQL());
    }
}
