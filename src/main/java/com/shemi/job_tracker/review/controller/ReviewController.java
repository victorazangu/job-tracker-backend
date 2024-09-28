package com.shemi.job_tracker.review.controller;

import com.shemi.job_tracker.review.entity.Review;
import com.shemi.job_tracker.review.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl service;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getCompaniesReviews(@PathVariable("companyId") Long companyId) {
        return ResponseEntity.ok(service.getCompaniesReviews(companyId));
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> addReviewToCompany(@PathVariable Long companyId, @RequestBody Review review) {
        return ResponseEntity.ok(service.addReviewToCompany(review, companyId));
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getSingleReview(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        return ResponseEntity.ok(service.getSingleReview(companyId, reviewId));
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        return ResponseEntity.ok(service.updateReview(companyId, reviewId, review));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        service.deleteReview(companyId, reviewId);
        return ResponseEntity.ok("Review deleted successfully");
    }
}
