package com.shemi.job_tracker.company.repository;

import com.shemi.job_tracker.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
