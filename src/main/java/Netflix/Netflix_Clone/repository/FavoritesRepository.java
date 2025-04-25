package Netflix.Netflix_Clone.repository;

import Netflix.Netflix_Clone.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites,Long> {

    List<Favorites> findByUserId(Long userId);
}
