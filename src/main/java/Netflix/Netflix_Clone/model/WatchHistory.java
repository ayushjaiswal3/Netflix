package Netflix.Netflix_Clone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key to User
    private User user;  // The user who watched the video

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)  // Foreign key to Video
    private Video video;  // The video that was watched

    private LocalDateTime watchedAt;  // Timestamp when the video was watched

    private Long watchTime;  // Time spent watching (in minutes or seconds)

    private LocalDateTime completedAt;  // Optional: Timestamp when the video was completed (if applicable)

}
