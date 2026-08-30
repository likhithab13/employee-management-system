package com.restapi.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByMobileOrEmail(Long mobile, String email);

    List<Employee> findByDepartment(String dept);
}
