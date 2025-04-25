package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.Webseries;
import Netflix.Netflix_Clone.service.WebSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/WebSeries")
public class WebSeriesController {

    @Autowired
    private WebSeriesService webSeriesService;

    @PostMapping
    public Webseries saveWebseries(@RequestBody Webseries webseries) {
        return webSeriesService.saveWebseries(webseries);
    }

    @GetMapping
    public List<Webseries> getAllWebSeries() {
        return webSeriesService.getAllWebSeries();
    }

    @GetMapping("/{id}")
    public Webseries getWebSeriesById(@PathVariable Long id) {
        return webSeriesService.getWebSeriesById(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Webseries> getWebSeriesByGenre(@PathVariable String genre) {
        return webSeriesService.getWebSeriesByGenre(genre);
    }

    @DeleteMapping("/{id}")
    public void deleteWebSeries(@PathVariable Long id) {
        webSeriesService.deleteWebSeries(id);
    }
}
