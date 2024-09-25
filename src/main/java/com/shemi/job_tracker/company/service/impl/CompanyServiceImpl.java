package com.shemi.job_tracker.company.service.impl;

import com.shemi.job_tracker.company.entity.Company;
import com.shemi.job_tracker.company.repository.CompanyRepository;
import com.shemi.job_tracker.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company createCompany(Company company) {
        return repository.save(company);
    }

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public Optional<Company> getCompany(Long id) {
        return repository.findById(id);
    }

    public Company updateCompany(Long id, Company body) {
        Optional<Company> company = repository.findById(id);
        if (company.isPresent()) {
            company.get().setName(body.getName());
            company.get().setDescription(body.getDescription());
            return repository.save(company.get());
        }
        return null;
    }

    public void deleteCompany(Long id) {
        repository.deleteById(id);
    }
}
