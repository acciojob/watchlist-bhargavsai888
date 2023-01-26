package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController

public class MovieController {
    @Autowired
    private MovieService movieService;

@PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
    String message=movieService.addMovie(movie);
    return new ResponseEntity<>(message, HttpStatus.CREATED);
}
    @PostMapping("/movies/add-director")
    public ResponseEntity<String>  addDirector(@RequestBody() Director director){
        String message=movieService.addDirector(director);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @PutMapping("/movies/add-movie-director-pair/{director}/{movie}")
    public ResponseEntity<String>   addMovieDirectorPair(@PathVariable() String director,@PathVariable String movie){
        String message=movieService. addMovieDirectorPair(director,movie);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movie-by-name")
    public ResponseEntity<Movie> getMovieByName(@RequestParam String name){
     Movie result=movieService.getMovieByName(name);
     return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        Director director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-director-by-movie")
    public ResponseEntity<String> getDirectorByMovieName(@RequestParam String name){
    String response=movieService.getDirectorByMovieName(name);
    return new ResponseEntity<>(response,HttpStatus.FOUND);
}

    @GetMapping("/movies/get-movies-by-director-name")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam String director){
    List<String> movies=movieService.getMoviesByDirectorName(director);
    return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>>  findAllMovies(){
    List<String> movies=movieService. findAllMovies();
    return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
    String message=movieService.deleteDirectorByName(name);
    return new ResponseEntity<>(message,HttpStatus.GONE);

    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
    String response=movieService.deleteAllDirectors();
    return new ResponseEntity<>(response,HttpStatus.GONE);
    }
}
