package com.shemi.job_tracker.job.service;

import com.shemi.job_tracker.job.entity.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface JobService {
    public List<Job> getAllJobs();

    public void createJob(Job job);

    public Optional<Job> findById(Long id);

    public Job updateJob(Long id, Job job);

    public String deleteJob(Long id);
}
