package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pelicula {
    private Long id;
    private String titulo;
    private int anio;
    private String director;
    private String genero;
    private String sinopsis;
}
