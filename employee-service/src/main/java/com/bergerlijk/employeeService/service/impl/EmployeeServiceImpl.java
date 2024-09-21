package com.bergerlijk.employeeService.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bergerlijk.employeeService.dto.APIResponseDto;
import com.bergerlijk.employeeService.dto.DepartmentDto;
import com.bergerlijk.employeeService.dto.EmployeeDto;
import com.bergerlijk.employeeService.dto.OrganizationDto;
import com.bergerlijk.employeeService.mapper.EmployeeMapper;
import com.bergerlijk.employeeService.model.Employee;
import com.bergerlijk.employeeService.repository.EmployeeRepository;
import com.bergerlijk.employeeService.service.DepartmentApiClient;
import com.bergerlijk.employeeService.service.EmployeeService;
import com.bergerlijk.employeeService.service.OrganizationApiClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
    private DepartmentApiClient departmentApiClient;
    private OrganizationApiClient organizationApiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentApiClient departmentApiClient,
            OrganizationApiClient organizationApiClient) {
        this.employeeRepository = employeeRepository;
        this.departmentApiClient = departmentApiClient;
        this.organizationApiClient = organizationApiClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }

    @Override
    // @CircuitBreaker(name = "${spring.application.name}", fallbackMethod =
    // "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        DepartmentDto departmentDto = departmentApiClient.getDepartment(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationApiClient.getOrganization(employee.getOrganizationCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        DepartmentDto departmentDto = new DepartmentDto(employeeId, null, null, null, null);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        // apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }

}
