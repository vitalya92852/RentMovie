package org.example.rentmovie.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "actor")

public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
}
