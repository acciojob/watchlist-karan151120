package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    List<Movie> movieList = new ArrayList<>();
    List<Director> directorList = new ArrayList<>();
    HashMap<Director, List<Movie>> directorListHashMap = new HashMap<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public HashMap<Director, List<Movie>> getDirectorListHashMap() {
        return directorListHashMap;
    }

    public void setDirectorListHashMap(HashMap<Director, List<Movie>> directorListHashMap) {
        this.directorListHashMap = directorListHashMap;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
}
