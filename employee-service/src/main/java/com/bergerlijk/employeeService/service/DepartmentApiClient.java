package com.bergerlijk.employeeService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bergerlijk.employeeService.dto.DepartmentDto;

@FeignClient(name = "department-service")
public interface DepartmentApiClient {

    // Build get department rest api
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
