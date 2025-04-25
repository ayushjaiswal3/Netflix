package Netflix.Netflix_Clone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;  // Genre name (e.g., Action, Comedy, Drama)

    @ManyToMany(mappedBy = "genres")
    private List<Video> videos;


    @ManyToMany(mappedBy = "genres")
    private List<Webseries> webseries;
}
