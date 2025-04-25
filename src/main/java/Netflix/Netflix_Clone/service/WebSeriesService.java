package Netflix.Netflix_Clone.service;

import Netflix.Netflix_Clone.model.Webseries;

import java.util.List;

public interface WebSeriesService {

    Webseries saveWebseries(Webseries webseries);

    List<Webseries> getAllWebSeries();

    Webseries getWebSeriesById(Long id);

    List<Webseries> getWebSeriesByGenre(String genre);

    void deleteWebSeries(Long id);

}
