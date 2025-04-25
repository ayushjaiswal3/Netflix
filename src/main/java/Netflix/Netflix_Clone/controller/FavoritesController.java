package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.Favorites;
import Netflix.Netflix_Clone.service.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @PostMapping
    public ResponseEntity<Favorites> saveFavorite(@RequestBody Favorites favorites) {
        return ResponseEntity.ok(favoritesService.saveFavorite((favorites)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorites>> getFavoritesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(favoritesService.getFavoritesByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long id) {
        favoritesService.removeFavorite(id);
        return ResponseEntity.ok().build();
    }
}
