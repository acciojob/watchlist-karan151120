package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    MovieService movieService = new MovieService();

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("movie added sucessfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("director added sucessfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie name")String movie, @RequestParam("director name")String director) {
        movieService.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("movie-director pair added sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name) {
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name) {
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("director")String name) {
        List<Movie> l = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(l, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> l = movieService.findAllMovies();
        return new ResponseEntity<>(l, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director’s name")String name) {
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("director deleted sucessfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("all directors deleted sucessfully", HttpStatus.CREATED);
    }
}
