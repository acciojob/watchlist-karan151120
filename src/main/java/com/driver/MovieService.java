package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository = new MovieRepository();


    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director);
    }

    public List<String> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void deleteDirectorByName(String director) {
        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
