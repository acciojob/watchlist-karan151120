package com.driver;

import org.springframework.stereotype.Repository;

import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();
    HashMap<Director, List<String>> movieDirectorPairHashMap = new HashMap<>();


    public void addMovie(Movie movie) {
        String name = movie.getName();

        movieHashMap.put(name, movie);
    }

    public void addDirector(Director director) {
        String name = director.getName();

        directorHashMap.put(name, director);
    }


    public void addMovieDirectorPair(String movie, String director) {
        Movie movie1 = movieHashMap.get(movie);
        Director director1 = directorHashMap.get(director);

        if(movieDirectorPairHashMap.containsKey(director1)) {
            List<String> l = movieDirectorPairHashMap.get(director1);
            l.add(movie);
            movieDirectorPairHashMap.put(director1,l);
        }
        else {
            List<String> l = new ArrayList<>();
            l.add(movie);
            movieDirectorPairHashMap.put(director1,l);
        }

    }

    public Movie getMovieByName(String name) {
        return movieHashMap.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorHashMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String director) {
        Director director1 = directorHashMap.get(director);

        return movieDirectorPairHashMap.getOrDefault(director1, new ArrayList<>());
    }

    public List<String> getAllMovies() {
        List<String> l = new ArrayList<>();
        for(String s : movieHashMap.keySet()) {
            l.add(s);
        } return l;
    }

    public void deleteDirectorByName(String director) {
        Director director1 = directorHashMap.get(director);
        List<String> l = movieDirectorPairHashMap.getOrDefault(director1, new ArrayList<>());

        movieDirectorPairHashMap.remove(director1);
        directorHashMap.remove(director);

        for(String s : l) {
            movieHashMap.remove(s);
        }
    }

    public void deleteAllDirectors() {

        for(List<String> student : movieDirectorPairHashMap.values()) {
            for(String s : student) {
                if(movieHashMap.containsKey(s)) movieHashMap.remove(s);
            }
        }

        for(Director director : movieDirectorPairHashMap.keySet()) {
            movieDirectorPairHashMap.remove(director);
        }

        for(String director : directorHashMap.keySet()) {
            directorHashMap.remove(director);
        }
    }
}
