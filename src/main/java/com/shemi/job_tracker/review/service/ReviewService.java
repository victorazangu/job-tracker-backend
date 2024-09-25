package com.shemi.job_tracker.review.service;

import com.shemi.job_tracker.review.entity.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> getCompaniesReviews(Long companyId);
    public Review addReviewToCompany(Review review, Long companyId);
    public List<Review> getSingleReview(Long companyId, Long reviewId);
    public Review updateReview(Long companyId, Long reviewId, Review review);
    public void deleteReview(Long companyId, Long reviewId);
}
