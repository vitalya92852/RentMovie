package org.example.rentmovie.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    private String genre;

    @Column(columnDefinition = "numeric(4,2)")
    private Double numeric;

    private Integer count;

    @OneToMany(mappedBy = "movie")
    private List<ActorEntity> actorList;

    @OneToMany(mappedBy = "movie")
    private List<DirectorEntity> directorList;



}
