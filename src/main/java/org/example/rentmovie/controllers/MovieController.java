package org.example.rentmovie.controllers;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.example.rentmovie.dtos.MovieDTO;
import org.example.rentmovie.entities.MovieEntity;
import org.example.rentmovie.repositories.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Builder
@RequestMapping(path = "/api")
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping("/films")
    public ResponseEntity<List<MovieDTO>> getMovies(){
        return ResponseEntity.ok(
                MovieDTO.createMovieDTOList(movieRepository.findAll())
        );
    }

    @DeleteMapping("/films/{movieId}")
    public ResponseEntity<String> deleteMovie(@RequestParam("movieId") Long movieId){
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if(movie.isPresent()){
            movieRepository.delete(movie.get());
            return ResponseEntity.ok("Фильм успешно удален");
        }
        return ResponseEntity.notFound().build();
    }
}
