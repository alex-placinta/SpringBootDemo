package com.sda.spring.service.impl;

import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;
import com.sda.spring.repository.CompanyRepository;
import com.sda.spring.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
class CompanyServiceImplTest {

    public static final String NAME = "Grigore SRL";
    public static final String REGISTRATION_NUMBER = "123455";
    public static final String NAME2 = "Auchan SRL";
    public static final String REGISTRATION_NUMBER2 = "32435";

    @InjectMocks
    private CompanyServiceImpl service;

    @Mock
    private CompanyRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
    }

    @Test
    void getAllCompanies() {
        List<Company> companyList = new ArrayList<>();
        Company company1 = new Company();
        company1.setName(NAME);
        company1.setRegistrationNumber(REGISTRATION_NUMBER);
        company1.setId(1);

        Company company2 = new Company();
        company2.setName(NAME2);
        company2.setRegistrationNumber(REGISTRATION_NUMBER2);
        company2.setId(2);

        companyList.add(company1);
        companyList.add(company2);

        Mockito.when(repository.findAll()).thenReturn(companyList);

        List<CompanyInfoDto> result = service.getAllCompanies();

        Assertions.assertEquals(result.size(), 2);

        Assertions.assertEquals(result.get(0).getName(), NAME);
        Assertions.assertEquals(result.get(0).getId(), 1);

        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void testGetAllCompanies() {
    }

    @Test
    void populateDb() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByNameAndRegistration() {
        // construim obiectul asteptat(expected)
        Company company = new Company();
        company.setId(1);
        company.setName(NAME);
        company.setRegistrationNumber(REGISTRATION_NUMBER);

        //invatam(mock-uim) interfata repository sa intoarca company
        Mockito.when(repository.findByNameAndRegistrationNumber(NAME, REGISTRATION_NUMBER))
                .thenReturn(Optional.of(company));

        //extragem rezultatul obtinut in urma apelului metodei din service
        CompanyInfoDto result = service.findByNameAndRegistration(NAME, REGISTRATION_NUMBER);


        //verificam daca rezultatul obtinut este egal cu cel asteptat
        Assertions.assertEquals(result.getName(), company.getName());
        Assertions.assertEquals(result.getRegistrationNumber(), company.getRegistrationNumber());

        Mockito.verify(repository, Mockito.times(1)).findByNameAndRegistrationNumber(NAME, REGISTRATION_NUMBER);
    }
}