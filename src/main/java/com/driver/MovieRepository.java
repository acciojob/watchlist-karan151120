package com.driver;

import org.springframework.stereotype.Repository;

import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<String, List<Movie>> directorListHashMap = new HashMap<>();


    public void addMovie(Movie movie) {
        movieDb.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorDb.put(director.getName(), director);
    }


    public void addMovieDirectorPair(String movie, String director) {
        if(directorListHashMap.containsKey(director)) {
            List<Movie> l = directorListHashMap.get(director);
            l.add(movieDb.get(movie));
            directorListHashMap.put(director, l);
        }
        else {
            List<Movie> l = new ArrayList<>();
            l.add(movieDb.get(movie));
            directorListHashMap.put(director, l);
        }
    }

    public Movie getMovieByName(String name) {
       return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorDb.get(name);
    }

    public List<Movie> getMoviesByDirectorName(String name) {
        return directorListHashMap.get(name);
    }

    public List<Movie> findAllMovies() {
        List<Movie> l = new ArrayList<>();
        for(Movie movie : movieDb.values()) {
            l.add(movie);
        }
        return l;
    }

    public void deleteDirectorByName(String name) {
        List<Movie> l = directorListHashMap.get(directorDb.get(name));

        directorListHashMap.remove(name);
        directorDb.remove(name);

        for(Movie movie : l) {
            movieDb.remove(movie.getName());
        }
    }

    public void deleteAllDirectors() {
        for(String name : directorDb.keySet()) {
            deleteDirectorByName(name);
        }
    }
}
