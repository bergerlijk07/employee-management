package com.bergerlijk.employeeService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bergerlijk.employeeService.dto.DepartmentDto;
import com.bergerlijk.employeeService.dto.OrganizationDto;

@FeignClient(name = "organization-service")
public interface OrganizationApiClient {

    // Build get department rest api
    @GetMapping("api/organizations/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String organizationCode);
}
