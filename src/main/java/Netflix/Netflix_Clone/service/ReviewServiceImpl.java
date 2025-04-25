package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Review;
import Netflix.Netflix_Clone.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewByVideoId(Long videoId) {
        return reviewRepository.findByVideoId(videoId);
    }

    @Override
    public List<Review> getReviewByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
