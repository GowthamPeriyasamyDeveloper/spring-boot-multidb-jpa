package io.github.gowtham.spring_boot_multidb_jpa.postgres.controller;

import io.github.gowtham.spring_boot_multidb_jpa.postgres.dto.CreateEmployeeRequest;
import io.github.gowtham.spring_boot_multidb_jpa.postgres.entity.PostgresEmployee;
import io.github.gowtham.spring_boot_multidb_jpa.service.MultiDbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postgres/employee")
public class PostgresController
{
    private final MultiDbService multiDbService;

    public PostgresController(MultiDbService multiDbService)
    {
        this.multiDbService = multiDbService;
    }

    @PostMapping
    public ResponseEntity<?> savePostgresEmployee(@RequestBody CreateEmployeeRequest employeeRequest)
    {
        PostgresEmployee postgresEmployee = new PostgresEmployee();

        postgresEmployee.setName(employeeRequest.getEmployeeName());

        return ResponseEntity.accepted().body(multiDbService.saveEmployeeToPostgres(postgresEmployee));
    }

    @GetMapping
    public ResponseEntity<?> getPostgresEmployeeDetails()
    {
        return ResponseEntity.ok(multiDbService.fetchFromPostgres());
    }


}
