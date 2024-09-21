package com.bergerlijk.employeeService.dto;

public class DepartmentDto {

    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentDescription;
    private String departmentCode;
    
    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String departmentName, String departmentAddress, String departmentDescription, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentDescription = departmentDescription;
        this.departmentCode = departmentCode;
    }

    //getter and setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentAddress() {
        return departmentAddress;
    }
    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }
    public String getDepartmentDescription() {
        return departmentDescription;
    }
    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }
    public String getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
