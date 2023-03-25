package com.driver;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    MovieService movieService = new MovieService();

    @PostMapping("/POST /movies/add-movie")
    public String addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PostMapping("POST /movies/add-director")
    public String addDirector(@RequestBody Director director) {
        return movieService.addDirector(director);
    }

    @PostMapping("PUT /movies/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("movie name")Movie movie, @RequestParam("director name")Director director) {
        return movieService.addMovieDirectorPair(movie, director);
    }

    @GetMapping("GET /movies/get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name")String name) {
        return movieService.getMovieByName(name);
    }

    @GetMapping("GET /movies/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name")String name) {
        return movieService.getDirectorByName(name);
    }

    @GetMapping("GET /movies/get-movies-by-director-name/{director}")
    public List<Movie> getMoviesByDirectorName(@PathVariable("director")String name) {
        return movieService.getMoviesByDirectorName(name);
    }

    @GetMapping("GET /movies/get-all-movies")
    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    @DeleteMapping("DELETE /movies/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("director’s name")String name) {
        return movieService.deleteDirectorByName(name);
    }

    @DeleteMapping("DELETE /movies/delete-all-directors")
    public String deleteAllDirectors() {
        return movieService.deleteAllDirectors();
    }
}
