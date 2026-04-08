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

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
            .<ResponseEntity<Object>>map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(404).body(Map.of("mensaje", "Película no encontrada")));
    }

    @PostMapping
    public ResponseEntity<Object> crear(@RequestBody Pelicula pelicula) {
        Pelicula creada = service.crear(pelicula);
        return ResponseEntity.status(201).body(Map.of(
            "mensaje", "Película creada correctamente",
            "pelicula", creada
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.ok(Map.of("mensaje", "Película eliminada correctamente"));
        }
        return ResponseEntity.status(404).body(Map.of("mensaje", "Película no encontrada"));
    }
}
