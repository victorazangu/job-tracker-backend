package com.shemi.job_tracker.company.entity;

import com.shemi.job_tracker.job.entity.Job;
import com.shemi.job_tracker.review.entity.Review;
import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Job> jobs;

    @OneToMany
    private List<Review> reviews;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}
