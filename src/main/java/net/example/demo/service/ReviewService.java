package net.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import net.example.demo.repository.ReviewRepository;
import net.example.demo.entity.Review;
import net.example.demo.exception.ReviewNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // Lấy tất cả các đánh giá
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Lấy đánh giá theo ID
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }

    // Tạo một đánh giá mới
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Cập nhật đánh giá theo ID
    public Review updateReview(Long id, Review reviewDetails) {
        Review review = getReviewById(id);
        review.setContent(reviewDetails.getContent());
        review.setRating(reviewDetails.getRating());
        review.setProductId(reviewDetails.getProductId());
        return reviewRepository.save(review);
    }

    // Xóa đánh giá theo ID
    public void deleteReview(Long id) {
        Review review = getReviewById(id);
        reviewRepository.delete(review);
    }
}
