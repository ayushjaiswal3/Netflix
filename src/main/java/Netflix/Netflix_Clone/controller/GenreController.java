package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.Genre;
import Netflix.Netflix_Clone.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor

public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.saveGenre(genre));
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenre() {
        return ResponseEntity.ok(genreService.getAllGenre());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Genre genre = genreService.getGenreById(id);
        return genre != null ? ResponseEntity.ok(genre) : ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Genre> getGenreByName(@PathVariable String name) {
        Genre genre = genreService.getGenreByName(name);
        return genre != null ? ResponseEntity.ok(genre) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok().build();
    }
}
