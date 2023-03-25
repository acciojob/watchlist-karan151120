package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository = new MovieRepository();

    public String addMovie(Movie movie) {
        movieRepository.getMovieList().add(movie);
        return "sucess";
    }

    public String addDirector(Director director) {
        movieRepository.getDirectorList().add(director);
        return "sucess";
    }

    public String addMovieDirectorPair(Movie movie, Director director) {
        List<Movie> l = movieRepository.getDirectorListHashMap().getOrDefault(director, new ArrayList<>());
        l.add(movie);
        movieRepository.getDirectorListHashMap().put(director, l);

        return "sucess";
    }

    public Movie getMovieByName(String name) {
        List<Movie> l = movieRepository.getMovieList();

        for(Movie movie : l) {
            if(movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName(String name) {
        List<Director> l = movieRepository.getDirectorList();

        for(Director director : l) {
            if(director.getName().equals(name)) {
                return director;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByDirectorName(String name) {
        Director director = getDirectorByName(name);

        List<Movie> l = movieRepository.getDirectorListHashMap().getOrDefault(director, new ArrayList<>());

        return l;
    }

    public List<Movie> findAllMovies() {
        return movieRepository.getMovieList();
    }

    public String deleteDirectorByName(String name) {
        Director director = getDirectorByName(name);
        List<Movie> l = movieRepository.getDirectorListHashMap().get(director);

        movieRepository.getDirectorListHashMap().remove(director);
        movieRepository.getDirectorListHashMap().remove(director);

        List<Movie> last = movieRepository.getMovieList();

        for(Movie movie : l) {
            for(Movie m : last) {
                if(movie==m) {
                    last.remove(m);
                }
            }
        }
        movieRepository.setMovieList(last);
        return "sucess";
    }

    public String deleteAllDirectors() {
        HashSet<Movie> hs = new HashSet<>();
        HashMap<Director,List<Movie>> hm = movieRepository.getDirectorListHashMap();
        for(List<Movie> l : hm.values()) {
            for(Movie movie : l) {
                hs.add(movie);
            }
        }
        movieRepository.setDirectorList(new ArrayList<Director>());
        movieRepository.setDirectorListHashMap(new HashMap<Director, List<Movie>>());

        for (Movie movie : movieRepository.getMovieList()) {
            if(hs.contains(movie)) {
                hm.remove(movie);
            }
        }

        return "sucess";
    }
}
