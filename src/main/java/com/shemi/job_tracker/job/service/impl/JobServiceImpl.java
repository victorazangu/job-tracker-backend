package com.shemi.job_tracker.job.service.impl;

import com.shemi.job_tracker.job.entity.Job;
import com.shemi.job_tracker.job.repository.JobRepository;
import com.shemi.job_tracker.job.service.JobService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository repository;

    @Autowired
    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    public void createJob(Job job) {
        synchronized (this) {
            repository.save(job);
        }
    }

    public Optional<Job> findById(Long id) {
        return repository.findById(id);
    }

    public Job updateJob(Long id, Job job) {
        Optional<Job> jobOptional = repository.findById(id);
        if (jobOptional.isPresent()) {
            Job jobToUpdate = jobOptional.get();
            jobToUpdate.setTitle(job.getTitle());
            jobToUpdate.setDescription(job.getDescription());
            jobToUpdate.setMinSalary(job.getMinSalary());
            jobToUpdate.setMaxSalary(job.getMaxSalary());
            jobToUpdate.setLocation(job.getLocation());
            return repository.save(jobToUpdate);
        } else {
            throw new EntityNotFoundException("Job not found with id: " + id);
        }
    }

    public String deleteJob(Long id) {
        repository.deleteById(id);
        return "Job deleted successfully";
    }
}
