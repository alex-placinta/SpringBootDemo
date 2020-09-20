package com.sda.spring.controller;

import com.sda.spring.components.CustomFaker;
import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.exception.CompanyNotFoundException;
import com.sda.spring.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@ControllerAdvice
public class CompanyController {

    private final CompanyService companyService;
    private final CustomFaker customFaker;

    @Autowired
    public CompanyController(CompanyService companyService, CustomFaker customFaker) {
        this.companyService = companyService;
        this.customFaker = customFaker;
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyInfoDto> create(@RequestBody CompanyCreateDto companyCreateDto){
        return ResponseEntity.ok(companyService.create(companyCreateDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyInfoDto>> getAllCompanies(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy) {

        return ResponseEntity.ok(companyService.getAllCompanies(pageNo,pageSize,sortBy));
    }

    @GetMapping("/populate")
    public void faker(){
        companyService.populateDb(customFaker.createDummyCompanyList());
    }

    @GetMapping("/findById")
    public ResponseEntity<CompanyInfoDto> findById(@RequestParam Integer id) {
        if (id == null) {
            throw new CompanyNotFoundException("Id cannot be null!");
        } else {
            return ResponseEntity.ok(companyService.findById(id));
        }

    }
}
