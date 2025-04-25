package Netflix.Netflix_Clone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Unique identifier for the favorite entry

    @ManyToOne
    @JoinColumn(name = "user_id")  // Foreign key to User entity
    private User user;

    @ManyToOne
    @JoinColumn(name = "video_id")  // Foreign key to Video entity
    private Video video;

    private Date addedAt;  // The date when the video was added to the user's favorites list

}
