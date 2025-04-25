package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Review;

import java.util.List;

public interface ReviewService {

    Review saveReview(Review review);

    List<Review> getReviewByVideoId(Long videoId);

    List<Review> getReviewByUserId(Long userId);

    void deleteReview(Long id);

}
