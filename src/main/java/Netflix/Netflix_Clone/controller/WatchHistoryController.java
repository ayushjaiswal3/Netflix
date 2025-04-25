package Netflix.Netflix_Clone.controller;

import Netflix.Netflix_Clone.model.WatchHistory;
import Netflix.Netflix_Clone.service.WatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watch-history")
public class WatchHistoryController {

    @Autowired
    private WatchHistoryService watchHistoryService;

    @PostMapping
    public WatchHistory saveWatchHistory(@RequestBody WatchHistory watchHistory) {
        return watchHistoryService.saveWatchHistory(watchHistory);
    }

    @GetMapping("/user/{userId}")
    public List<WatchHistory> getWatchHistoryByUserId(@PathVariable Long userId) {
        return watchHistoryService.getWatchHistoryByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteWatchHistoryById(@PathVariable Long id) {
        watchHistoryService.deleteWatchHistoryById(id);
    }
}
