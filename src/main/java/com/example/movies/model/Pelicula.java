package com.example.movies.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PELICULAS", schema = "ADMIN")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "ANIO")
    private int anio;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "SINOPSIS")
    private String sinopsis;
}
