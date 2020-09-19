package com.sda.spring.service;


import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.dto.CompanyInfoDto;
import java.util.List;

public interface CompanyService {

    CompanyInfoDto create(CompanyCreateDto company);

    List<CompanyInfoDto> getAllCompanies();
}
