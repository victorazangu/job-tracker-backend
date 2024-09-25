package com.shemi.job_tracker.job.controller;

import com.shemi.job_tracker.job.entity.Job;
import com.shemi.job_tracker.job.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        List<Job> jobs = service.getAllJobs();
        Map<String,String> errors = new HashMap<>();
        errors.put("error", "Not Found");
        if (jobs.isEmpty()) {
            return new ResponseEntity<>(errors, NOT_FOUND);
        }
        return ResponseEntity.ok(jobs);
    }

    @PostMapping("/")
    public void addJob(@RequestBody Job job) {
        service.createJob(job);
    }

    @GetMapping("/{id}")
    public Optional<Job> findOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@RequestBody Job job, @PathVariable Long id) {
        return service.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        return service.deleteJob(id);
    }
}
