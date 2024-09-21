package com.bergerlijk.employeeService.service;

import com.bergerlijk.employeeService.dto.APIResponseDto;
import com.bergerlijk.employeeService.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
