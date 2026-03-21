package com.example.movies.repository;

import com.example.movies.model.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaRepository {

    private static final List<Pelicula> peliculas = List.of(
        new Pelicula(1L, "Volver al Futuro", 1985, "Robert Zemeckis", "Ciencia ficción",
            "Un adolescente viaja accidentalmente al pasado en un auto DeLorean y debe asegurarse de que sus padres se enamoren para poder regresar al futuro."),
        new Pelicula(2L, "Interestelar", 2014, "Christopher Nolan", "Ciencia ficción",
            "Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad."),
        new Pelicula(3L, "Harry Potter y la Piedra Filosofal", 2001, "Chris Columbus", "Fantasía",
            "Un joven huérfano descubre que es un mago y es admitido en la escuela de magia y hechicería Hogwarts."),
        new Pelicula(4L, "Doctor Strange", 2016, "Scott Derrickson", "Acción",
            "Un brillante neurocirujano descubre el mundo de la magia y las dimensiones alternativas tras sufrir un accidente."),
        new Pelicula(5L, "El Código Enigma", 2014, "Morten Tyldum", "Drama",
            "La historia de Alan Turing, el matemático que descifró el código Enigma nazi durante la Segunda Guerra Mundial.")
    );

    public List<Pelicula> findAll() {
        return peliculas;
    }

    public Optional<Pelicula> findById(Long id) {
        return peliculas.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }
}
