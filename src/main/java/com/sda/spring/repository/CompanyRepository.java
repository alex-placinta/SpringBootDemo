package com.sda.spring.repository;

import com.sda.spring.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {

    @Query("select company from Company company where company.name = :name and company.registrationNumber = :registration")
    Optional<Company> findByNameAndRegistration(@Param("name") String name,@Param("registration") String registration);

    Optional<Company> findByNameAndRegistrationNumber(String name, String registrationNumber);

}
