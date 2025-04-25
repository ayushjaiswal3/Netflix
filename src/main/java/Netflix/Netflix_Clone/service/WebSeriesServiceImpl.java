package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Webseries;
import Netflix.Netflix_Clone.repository.WebSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSeriesServiceImpl implements WebSeriesService{

    @Autowired
    private WebSeriesRepository webSeriesRepository;

    @Override
    public Webseries saveWebseries(Webseries webseries) {
        return webSeriesRepository.save(webseries);
    }

    @Override
    public List<Webseries> getAllWebSeries() {
        return webSeriesRepository.findAll();
    }

    @Override
    public Webseries getWebSeriesById(Long id) {
        return webSeriesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Webseries> getWebSeriesByGenre(String genre) {
        return webSeriesRepository.findByGenreName(genre);
    }

    @Override
    public void deleteWebSeries(Long id) {
        webSeriesRepository.deleteById(id);
    }
}
