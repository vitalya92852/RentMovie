package org.example.rentmovie.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.rentmovie.entities.MovieEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long id;
    private String name;
    private int count;
    private String genre;
    private Double rating;

    public static MovieDTO createMovieDTO(MovieEntity movie){
        return builder()
                .id(movie.getId())
                .name(movie.getName())
                .count(movie.getCount())
                .genre(movie.getGenre())
                .rating(movie.getNumeric())
                .build();
    }

    public static List<MovieDTO> createMovieDTOList(List<MovieEntity> movieEntities){
        return movieEntities.stream().map(MovieDTO::createMovieDTO).collect(Collectors.toList());
    }

}
