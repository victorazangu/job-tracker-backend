package com.shemi.job_tracker.review.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private Long companyId;
    private String title;
    private String description;

    public Review() {
    }

    public Review(int id, Long companyId, String title, String description) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
