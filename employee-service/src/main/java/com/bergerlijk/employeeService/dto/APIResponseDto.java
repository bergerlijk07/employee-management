package com.bergerlijk.employeeService.dto;

public class APIResponseDto {

    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organization;

    public APIResponseDto() {
    }

    public APIResponseDto(EmployeeDto employee, DepartmentDto department, OrganizationDto organization) {
        this.employee = employee;
        this.department = department;
        this.organization = organization;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }
}
