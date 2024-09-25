package com.shemi.job_tracker.review.repository;

import com.shemi.job_tracker.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public List<Review> findAllByCompanyId(Long companyId);
    public Review findReviewByCompanyIdAndId(Long companyId, Long id);
    public  void deleteReviewByCompanyIdAndId(Long companyId, Long id);
}
