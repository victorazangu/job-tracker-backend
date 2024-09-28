package com.shemi.job_tracker.company.controller;

import com.shemi.job_tracker.company.entity.Company;
import com.shemi.job_tracker.company.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.ok(service.createCompany(company));
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(service.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> getCompany(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCompany(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company body, @PathVariable Long id) {
        return ResponseEntity.ok(service.updateCompany(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        service.deleteCompany(id);
        return ResponseEntity.ok("Company deleted successfully");
    }
}