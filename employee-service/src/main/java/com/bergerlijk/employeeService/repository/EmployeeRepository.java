package com.bergerlijk.employeeService.repository;

import org.springframework.stereotype.Repository;

import com.bergerlijk.employeeService.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
