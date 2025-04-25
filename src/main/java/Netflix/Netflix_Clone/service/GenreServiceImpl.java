package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Genre;
import Netflix.Netflix_Clone.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreByName(String genreName) {
        return genreRepository.findByName(genreName);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);

    }
}
