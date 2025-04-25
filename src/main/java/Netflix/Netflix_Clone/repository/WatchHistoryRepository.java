package Netflix.Netflix_Clone.repository;

import Netflix.Netflix_Clone.model.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory,Long> {

    List<WatchHistory> findByUserId(Long userId);
}
