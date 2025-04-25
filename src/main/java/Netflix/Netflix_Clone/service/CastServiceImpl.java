package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Cast;
import Netflix.Netflix_Clone.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastServiceImpl implements CastService{

    @Autowired
    private CastRepository castRepository;

    @Override
    public Cast saveCast(Cast cast) {
        return castRepository.save(cast);
    }

    @Override
    public Cast getCastById(Long id) {
        return castRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cast> getCastByVideoId(Long videoId) {
        return castRepository.findByVideoId(videoId);
    }

    @Override
    public List<Cast> getAllCast() {
        return castRepository.findAll();
    }

    @Override
    public void deleteCast(Long id) {
        castRepository.deleteById(id);
    }
}
