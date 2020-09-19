package com.sda.spring.service.impl;

import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;
import com.sda.spring.repository.CompanyRepository;
import com.sda.spring.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }


    @Override
    public CompanyInfoDto create(CompanyCreateDto companyCreateDto) {

        return toDto(repository.save(toEntity(companyCreateDto)));
    }

    @Override
    public List<CompanyInfoDto> getAllCompanies() {
        return toDtoList(repository.findAll());
    }

    private static List<CompanyInfoDto> toDtoList(Iterable<Company> entities) {
        List<CompanyInfoDto> results = new ArrayList<>();
        entities.forEach(entity -> results.add(toDto(entity)));
        return results;
    }

    private static Company toEntity(CompanyCreateDto companyCreateDto) {
        Company company = new Company();
        company.setAddress(companyCreateDto.getAddress());
        company.setEmail(companyCreateDto.getEmail());
        company.setName(companyCreateDto.getName());
        company.setPhoneNumber(companyCreateDto.getPhoneNumber());
        company.setRegistrationNumber(companyCreateDto.getRegistrationNumber());
        return company;
    }

    private static CompanyInfoDto toDto(Company company) {
        CompanyInfoDto companyInfoDto = new CompanyInfoDto();
        companyInfoDto.setAddress(company.getAddress());
        companyInfoDto.setEmail(company.getEmail());
        companyInfoDto.setCreatedAt(company.getCreatedAt());
        companyInfoDto.setCreatedBy(company.getCreatedBy());
        companyInfoDto.setRegistrationNumber(company.getRegistrationNumber());
        companyInfoDto.setPhoneNumber(company.getPhoneNumber());
        companyInfoDto.setId(company.getId());
        companyInfoDto.setName(company.getName());
        companyInfoDto.setUpdatedAt(company.getUpdatedAt());
        return companyInfoDto;

    }


}
