package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Favorites;

import java.util.List;

public interface FavoritesService {

    Favorites saveFavorite(Favorites favorites);

    List<Favorites> getFavoritesByUserId(Long userId);

    void removeFavorite(Long id);

}
