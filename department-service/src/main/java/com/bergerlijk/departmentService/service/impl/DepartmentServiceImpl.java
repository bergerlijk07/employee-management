package com.bergerlijk.departmentService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bergerlijk.departmentService.dto.DepartmentDto;
import com.bergerlijk.departmentService.mapper.DepartmentMapper;
import com.bergerlijk.departmentService.model.Department;
import com.bergerlijk.departmentService.repository.DepartmentRepository;
import com.bergerlijk.departmentService.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        
        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateDepartment'");
    }

    @Override
    public DepartmentDto getDepartment(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDepartment'");
    }

    @Override
    public List<DepartmentDto> getDepartments() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDepartments'");
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }

}
