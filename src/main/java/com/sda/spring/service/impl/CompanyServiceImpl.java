package com.sda.spring.service.impl;

import com.sda.spring.repository.CompanyRepository;
import com.sda.spring.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }
}
