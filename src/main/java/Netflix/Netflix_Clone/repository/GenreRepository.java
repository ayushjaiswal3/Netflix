package Netflix.Netflix_Clone.repository;

import Netflix.Netflix_Clone.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    Genre findByName(String genreName);

}
