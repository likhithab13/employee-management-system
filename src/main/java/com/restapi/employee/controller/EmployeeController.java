package com.restapi.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.employee.dto.ResponseDto;
import com.restapi.employee.entity.Employee;
import com.restapi.employee.service.Employeeservice;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    Employeeservice service;

    // CREATE
    @PostMapping("/employee")
    @Operation(summary = "Save a record")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseDto save(@RequestBody Employee employee) {
        return service.save(employee);
    }

    // READ ALL
    @GetMapping("/employee")
    @Operation(summary = "Fetch all records")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDto fetchAll() {
        return service.fetchAll();
    }

    // READ BY ID
    @GetMapping("/employee/{id}")
    @Operation(summary = "Fetch by ID")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDto fetchById(@PathVariable Integer id) {
        return service.fetchById(id);
    }

    // READ BY DEPARTMENT
    @GetMapping("/employee/department/{dept}")
    @Operation(summary = "Fetch by Department")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDto fetchByDepartment(@PathVariable String dept) {
        return service.fetchByDepartment(dept);
    }

    // DELETE
    @DeleteMapping("/employee/{id}")
    @Operation(summary = "Delete a Record")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    // FULL UPDATE
    @PutMapping("/employee/{id}")
    @Operation(summary = "Update record completely")
    public ResponseDto updateCompletely(@PathVariable Integer id, @RequestBody Employee employee) {
        return service.updateCompletely(id, employee);
    }

    // PARTIAL UPDATE
    @PatchMapping("/employee/{id}")
    @Operation(summary = "Update record partially")
    public ResponseDto updatePartially(@PathVariable Integer id, @RequestBody Employee employee) {
        return service.updatePartially(id, employee);
    }
}
