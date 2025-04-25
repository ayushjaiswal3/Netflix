package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Genre;
import Netflix.Netflix_Clone.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;  // Correct import
import java.util.List;

public interface VideoService {

    Video saveVideo(Video video);

    Video getVideoById(Long id);

    List<Video> getAllVideo();

    List<Video> getVideoByGenre(String genre);

    List<Video> searchVideo(String search);

    List<Video> getFeaturedVideo();

    Page<Video> getVideos(Pageable pageable, Double rating);

    void deleteVideo(Long id);
}
