package com.shemi.job_tracker.review.service.impl;

import com.shemi.job_tracker.review.entity.Review;
import com.shemi.job_tracker.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl {


    private final ReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> getCompaniesReviews(Long companyId) {
        return repository.findAllByCompanyId(companyId);
    }

    public Review addReviewToCompany(Review review, Long companyId) {
        var reviewTobe = new Review();
        reviewTobe.setCompanyId(companyId);
        reviewTobe.setDescription(review.getDescription());
        reviewTobe.setTitle(review.getTitle());
        return repository.save(reviewTobe);
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
