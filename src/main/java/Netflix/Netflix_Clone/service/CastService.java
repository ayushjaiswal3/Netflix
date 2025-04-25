package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Cast;

import java.util.List;

public interface CastService {

    Cast saveCast(Cast cast);

    Cast getCastById(Long id);

    List<Cast> getCastByVideoId(Long videoId);

    List<Cast> getAllCast();

    void deleteCast(Long id);

}
