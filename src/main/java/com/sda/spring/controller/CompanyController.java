package com.sda.spring.controller;


import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;
import com.sda.spring.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyInfoDto> create(@RequestBody CompanyCreateDto companyCreateDto) {
        return ResponseEntity.ok(companyService.create(companyCreateDto));  //this is what an endpoint looks like
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyInfoDto>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

}
