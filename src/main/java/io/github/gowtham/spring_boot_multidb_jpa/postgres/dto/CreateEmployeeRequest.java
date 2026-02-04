package io.github.gowtham.spring_boot_multidb_jpa.postgres.dto;

public class CreateEmployeeRequest
{
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}