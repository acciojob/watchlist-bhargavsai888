package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
     @Autowired
     private MovieRepository movieRepository;

public String addMovie(Movie movie){
    String message=movieRepository.addMovie(movie);
    return message;
}
public String addDirector(Director director){
    String message=movieRepository.addDirector(director);
    return message;
}
public String addMovieDirectorPair(String director,String movie){
    String message=movieRepository.addMovieDirectorPair(director,movie);
    return message;
}
public Movie getMovieByName(String name){
    Movie response=movieRepository.getMovieByName(name);
    return response;
}
public String getDirectorByMovieName(String name){
    String result=movieRepository.getDirectorByMovieName(name);
    return result;
}
public List<String> getMoviesByDirectorName(String name){
    List<String> moviesList=movieRepository.getMoviesByDirectorName(name);
    return moviesList;
}
public List<String> findAllMovies(){
   List<String> allMovies=movieRepository.findAllMovies();
   return allMovies;
}
public String deleteDirectorByName(String name){
    String message=movieRepository.deleteDirectorByName(name);
    return message;
}
public String deleteAllDirectors(){
    String value=movieRepository.deleteAllDirectors();
    return value;
}
}
