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
public class Webseries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int seasons;

    private int EpisodeNo;

    private String title;

    private String description;

    private String VideoUrl;

    private String thumbnailUrl;

    private LocalDateTime releaseDate;



    @ManyToMany
    @JoinTable(  // Specify the join table for the many-to-many relationship
            name = "webseries_genre",  // The join table's name
            joinColumns = @JoinColumn(name = "webseries_id"),  // Foreign key to Webseries
            inverseJoinColumns = @JoinColumn(name = "genre_id")  // Foreign key to Genre
    )
    private List<Genre> genres;

    @OneToMany(mappedBy = "webSeries",cascade = CascadeType.ALL)
    private List<Video> videos;
}
