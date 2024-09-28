package com.shemi.job_tracker.review.service.impl;

import com.shemi.job_tracker.company.entity.Company;
import com.shemi.job_tracker.company.service.impl.CompanyServiceImpl;
import com.shemi.job_tracker.review.entity.Review;
import com.shemi.job_tracker.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl {


    private final ReviewRepository repository;
    private final CompanyServiceImpl companyService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository, CompanyServiceImpl companyService) {
        this.repository = repository;
        this.companyService = companyService;
    }

    public List<Review> getCompaniesReviews(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    public Review addReviewToCompany(Review review, Long companyId) {
        Optional<Company> company = companyService.getCompany(companyId);
        if (company != null) {
            review.setCompany(company.get());
            return repository.save(review);
        }
        return null;
    }

    public Review getSingleReview(Long companyId, Long reviewId) {
        return repository.findReviewByCompanyIdAndId(companyId, reviewId);
    }

    public Review updateReview(Long companyId, Long reviewId, Review review) {
        return null;
    }

    public void deleteReview(Long companyId, Long reviewId) {
        repository.deleteReviewByCompanyIdAndId(companyId, reviewId);
    }
}
