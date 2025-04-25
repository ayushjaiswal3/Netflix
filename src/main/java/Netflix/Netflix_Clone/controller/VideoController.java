package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.Genre;
import Netflix.Netflix_Clone.model.Video;
import Netflix.Netflix_Clone.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/videos")

public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public Video saveVideo(@RequestBody Video video) {
        return videoService.saveVideo(video);
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideo();
    }

    @GetMapping("/rating")
    public Page<Video> getVideos(Pageable pageable, @RequestParam(required = false) Double rating) {
        return videoService.getVideos(pageable, rating);
    }

        @GetMapping("/genre/{genre}")
    public List<Video> getVideosByGenre(@PathVariable String genre) {
        return videoService.getVideoByGenre(genre);
    }

    @GetMapping("/search")
    public List<Video> searchVideos(@RequestParam String title) {
        return videoService.searchVideo(title);
    }

    @GetMapping("/featured")
    public List<Video> getFeaturedVideos() {
        return videoService.getFeaturedVideo();
    }

    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
    }
}
