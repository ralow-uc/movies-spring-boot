package com.example.movies.service;

import com.example.movies.model.Pelicula;
import com.example.movies.repository.PeliculaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository repository;
    private final EntityManager entityManager;

    public PeliculaService(PeliculaRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    public List<Pelicula> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Pelicula> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<?> testNativeQuery() {
        return entityManager.createNativeQuery(
            "SELECT COUNT(*) FROM ADMIN.PELICULAS"
        ).getResultList();
    }
}
