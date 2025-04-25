package Netflix.Netflix_Clone.repository;

import Netflix.Netflix_Clone.model.Genre;
import Netflix.Netflix_Clone.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;  // Correct import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByIsFeaturedTrue();

    List<Video> findByTitle(String title);

    @Query("SELECT v FROM Video v JOIN v.genres g WHERE g.name = :genreName")
    List<Video> findByGenres(@Param("genreName") String genreName);

    Page<Video> findByRatingGreaterThanEqual(Pageable pageable, Double rating);  // Correct method
}
