package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.Cast;
import Netflix.Netflix_Clone.service.CastService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cast")
@RequiredArgsConstructor
public class CastController {

    @Autowired
    private CastService castService;

    @PostMapping
    public ResponseEntity<Cast> saveCast(@RequestBody Cast cast) {
        return ResponseEntity.ok(castService.saveCast(cast));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cast> getCastById(@PathVariable Long id) {
        return ResponseEntity.ok(castService.getCastById(id));
    }

    @GetMapping
    public ResponseEntity<List<Cast>> getAllCast() {
        return ResponseEntity.ok(castService.getAllCast());
    }

    @GetMapping("/video/{videoId}")
    public ResponseEntity<List<Cast>> getCastByVideoId(@PathVariable Long videoId) {
        return ResponseEntity.ok(castService.getCastByVideoId(videoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCast(@PathVariable Long id) {
        castService.deleteCast(id);
        return ResponseEntity.ok().build();
    }
}
