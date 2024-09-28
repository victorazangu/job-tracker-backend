package com.shemi.job_tracker.company.service;

import com.shemi.job_tracker.company.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company createCompany(Company company);

    List<Company> getAllCompanies();

    Optional<Company> getCompany(Long id);

    Company updateCompany(Long id, Company body);

    void deleteCompany(Long id);
}
