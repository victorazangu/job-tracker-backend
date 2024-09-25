package com.shemi.job_tracker.job.repository;

import com.shemi.job_tracker.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface JobRepository extends JpaRepository<Job, Long> {
}
