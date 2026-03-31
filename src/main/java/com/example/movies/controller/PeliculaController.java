package com.example.movies.controller;

import com.example.movies.model.Pelicula;
import com.example.movies.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/test")
    public List<?> test() {
        return service.testNativeQuery();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
            .<ResponseEntity<Object>>map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(404).body(Map.of("mensaje", "Película no encontrada")));
    }
}
