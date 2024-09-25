package com.shemi.job_tracker.company.service;

import com.shemi.job_tracker.company.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public Company createCompany(Company company);

    public List<Company> getAllCompanies();

    public Optional<Company> getCompany(Long id);

    public Company updateCompany(Long id, Company body);

    public void deleteCompany(Long id);
}
