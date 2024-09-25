package com.shemi.job_tracker.review.controller;

import com.shemi.job_tracker.review.entity.Review;
import com.shemi.job_tracker.review.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl service;

    @GetMapping("/{companyId}/reviews")
    public List<Review> getCompaniesReviews(@PathVariable("companyId") Long companyId) {
        return service.getCompaniesReviews(companyId);
    }

    @PostMapping("/{companyId}/reviews")
    public Review addReviewToCompany(@PathVariable("companyId") Long companyId, @RequestBody Review review) {
        return service.addReviewToCompany(review, companyId);
    }

    @GetMapping("/{companyId}/reviews/{reviewId}")
    public Review getSingleReview(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        return service.getSingleReview(companyId, reviewId);
    }

    @PutMapping("/{companyId}/reviews/{reviewId}")
    public Review updateReview(@RequestBody Review review, @PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        return service.updateReview(companyId, reviewId, review);
    }

    @DeleteMapping("/{companyId}/reviews/{reviewId}")
    public String deleteReview(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        service.deleteReview(companyId, reviewId);
        return "Review deleted successfully";
    }
}
