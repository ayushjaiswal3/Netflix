package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Genre;

import java.util.List;

public interface GenreService {

    Genre saveGenre(Genre genre);

    Genre getGenreById(Long id);

    List<Genre> getAllGenre();

    Genre getGenreByName(String genreName);

    void deleteGenre(Long id);

}
