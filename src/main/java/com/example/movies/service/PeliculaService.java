package com.example.movies.service;

import com.example.movies.model.Pelicula;
import com.example.movies.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository repository;

    public PeliculaService(PeliculaRepository repository) {
        this.repository = repository;
    }

    public List<Pelicula> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
        return repository.findById(id);
    }
}
