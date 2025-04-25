package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.WatchHistory;

import java.util.List;

public interface WatchHistoryService {

    WatchHistory saveWatchHistory(WatchHistory watchHistory);

    List<WatchHistory> getWatchHistoryByUserId(Long userId);

    void deleteWatchHistoryById(Long id);

}
