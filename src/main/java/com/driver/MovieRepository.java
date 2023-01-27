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
        String name = movie.getName();
        if(!movieDb.containsKey(name)) {
            movieDb.put(name, movie);
        }
        return "Movie added successfully";
    }

    // 2 Add a director
    public String addDirector(Director dir){
        String name = dir.getName();
        if(!directorDb.containsKey(name)){
            directorDb.put(name, dir);
        }
        return "Director added successfully";
    }
    public String addMovieDirectorPair(String movie,String director){
        if(!movieDb.containsKey(movie) || !directorDb.containsKey(director)) return "Movie or Director not found in data base";
        if(movieDirector.containsKey(director)){
            movieDirector.get(director).add(movie);
        }else{
            List<String> ans = new ArrayList<>();
            ans.add(movie);
            movieDirector.put(director, ans);
        }
        return "Movie-Director Pair added successfully";
    }
   public Movie getMovieByName(String name){
        if(!movieDb.containsKey(name)){
            return null;
        }
       Movie movie=movieDb.get(name);
       return movie;
   }
    public Director getDirectorByName(String name){
        if(!directorDb.containsKey(name))return null;
        Director director=directorDb.get(name);
        return director;
    }
//   public String getDirectorByMovieName(String name){
//      if(directorDb.containsKey(name)){
//           String director=directorDb.get(name).getName();
//           return director;
//       }
//       return null;
//   }
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
       for(String director:movieDirector.keySet()){
           if(director.equals(name)){
               for (String movie:movieDirector.get(director)){
                   movieDb.remove(movie);
                   allMovies.remove(movie);
               }

           }
       }
       movieDirector.remove(name);
       directorDb.remove(name);
       return "success";
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
       return "Director deleted successfully";
   }
}
