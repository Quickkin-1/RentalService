package pl.pjatk.movieservice.service;

import pl.pjatk.movieservice.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {

        movies.add(new Movie(1L, "Matrix", true));
        movies.add(new Movie(2L, "John Wick", true));
        movies.add(new Movie(3L, "Interstellar", true));
    }

    public Movie getMovieById(Long id) {

        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Movie rentMovie(Long id) {

        Movie movie = getMovieById(id);

        if (movie != null) {
            movie.setIsAvailable(false);
        }

        return movie;
    }

    public Movie returnMovie(Long id) {

        Movie movie = getMovieById(id);

        if (movie != null) {
            movie.setIsAvailable(true);
        }

        return movie;
    }
}