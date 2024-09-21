package com.bergerlijk.departmentService.service;

import java.util.List;

import com.bergerlijk.departmentService.dto.DepartmentDto;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id);

    public DepartmentDto getDepartment(Long id);

    public List<DepartmentDto> getDepartments();

    DepartmentDto getDepartmentByCode(String code);
}
