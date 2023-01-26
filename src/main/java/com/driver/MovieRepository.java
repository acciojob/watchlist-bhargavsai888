package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb=new HashMap<>(); // for movie and its  properties
    HashMap<String, List<String>> movieDirector=new HashMap<>(); // for director and his movies

    HashMap<String,Director> directorDb=new HashMap<>();

    List<String>allMovies=new ArrayList<>(); // for All Movies

    public String addMovie(Movie movie){
        String name=movie.getName();
        movieDb.put(name,movie);
        allMovies.add(movie.getName());
        return "Success";
    }
    public String addDirector(Director director){
        String name=director.getName();
        directorDb.put(name,director);
        return "Success";
    }
    public String addMovieDirectorPair(String movie,String director){
        if (!movieDirector.containsKey(director)) {
            movieDirector.put(director,new ArrayList<>());
        }
        movieDirector.get(director).add(movie);
        return "Movie Director pair added";
    }
   public Movie getMovieByName(String name){
       Movie movie=movieDb.get(name);
       return movie;
   }
   public String getDirectorByMovieName(String name){
      if(directorDb.containsKey(name)){
           String director=directorDb.get(name).getName();
           return director;
       }
       return null;
   }
   public List<String> getMoviesByDirectorName(String name){
       for(String director:movieDirector.keySet()){
           if (director.equals(name)) {
             return movieDirector.get(name);
           }
       }
       return null;
   }
   public List<String> findAllMovies(){
        return allMovies;
   }
   public String deleteDirectorByName(String name){
      for(List<String> namesList:movieDirector.values()){
          if(namesList.equals(name)){
              allMovies.remove(namesList);
              movieDb.remove(namesList);
          }
      }
      movieDirector.remove(name);
      directorDb.remove(name);
      return "Director deleted successfully";
   }
   public String deleteAllDirectors(){
        for(List<String> movies:movieDirector.values()){
           for(String movie:movies){
               allMovies.remove(movie);
               movieDb.remove(movie);
           }

        }
       movieDirector.clear();
       directorDb.clear();
       return "All Director deleted successfully";
   }
}
