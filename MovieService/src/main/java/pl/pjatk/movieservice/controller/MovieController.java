package pl.pjatk.movieservice.controller;

import pl.pjatk.movieservice.model.Movie;
import pl.pjatk.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {

        Movie movie = movieService.getMovieById(id);

        if (movie == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Movie not found"
            );
        }

        return movie;
    }

    @PutMapping("/rent/{id}")
    public Movie rentMovie(@PathVariable Long id) {

        Movie movie = movieService.rentMovie(id);

        if (movie == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Movie not found"
            );
        }

        return movie;
    }

    @PutMapping("/return/{id}")
    public Movie returnMovie(@PathVariable Long id) {

        Movie movie = movieService.returnMovie(id);

        if (movie == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Movie not found"
            );
        }

        return movie;
    }
}