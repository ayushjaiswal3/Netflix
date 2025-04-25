package Netflix.Netflix_Clone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String type;  // Movie or TV Show

    private LocalDateTime releaseDate;  // Release date of the video



    private Long duration;  // Duration in minutes for movies, or episodes length for TV shows

    private int rating;  // Rating for the video, 1-10 or 0-100, or other scales

    private String thumbnailUrl;  // URL for thumbnail image

    private String bannerUrl;  // URL for banner image

    private String videoUrl;  // URL for the actual video content (could be from a streaming platform)

    private String trailerUrl;  // URL for the trailer

    private boolean isFeatured;  // Indicates if the video is featured in the UI

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<Favorites> favoritesList;  // List of users who have this video as a favorite

    @ManyToOne
    @JoinColumn(name = "webSeries_id")
    private Webseries webSeries;  // If the video is part of a web series, it will link to the web series

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<WatchHistory> watchHistoryList;  // List of watch history entries for this video

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<Review> reviews;  // List of reviews for the video

    @ManyToMany
    @JoinTable(name = "genre_video",
                  joinColumns = @JoinColumn(name = "video_id"),
                  inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "cast_video",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_id"))
    private List<Cast> casts;
}
