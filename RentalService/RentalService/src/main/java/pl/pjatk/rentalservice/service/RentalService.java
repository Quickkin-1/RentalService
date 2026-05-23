package pl.pjatk.rentalservice.service;

import pl.pjatk.rentalservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
 public class RentalService {

    private final RestTemplate restTemplate;

    private final String MOVIE_SERVICE_URL = "http://localhost:8081/movies";

    @Autowired
    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        return restTemplate.getForObject(
                MOVIE_SERVICE_URL + "/" + id,
                Movie.class
        );
    }

    public Movie returnMovie(Long id) {
        restTemplate.put(
                MOVIE_SERVICE_URL + "/return/" + id,
                null
        );

        return getMovie(id);
    }
}