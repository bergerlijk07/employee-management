package com.bergerlijk.organizationService.service.impl;

import org.springframework.stereotype.Service;

import com.bergerlijk.organizationService.dto.OrganizationDto;
import com.bergerlijk.organizationService.mapper.OrganizationMapper;
import com.bergerlijk.organizationService.model.Organization;
import com.bergerlijk.organizationService.repository.OrganizationRepository;
import com.bergerlijk.organizationService.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
