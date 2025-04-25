package Netflix.Netflix_Clone.repository;

import Netflix.Netflix_Clone.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByVideoId(Long videoId);
    List<Review> findByUserId(Long userId);
}
