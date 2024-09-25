package com.shemi.job_tracker.company.controller;

import com.shemi.job_tracker.company.entity.Company;
import com.shemi.job_tracker.company.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyServiceImpl service;

    @Autowired
    public CompanyController(CompanyServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return service.createCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompany(@PathVariable Long id) {
        return service.getCompany(id);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@RequestBody Company body, @PathVariable Long id) {
        return service.updateCompany(id, body);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id) {
        service.deleteCompany(id);
        return "Company deleted successfully";
    }
}