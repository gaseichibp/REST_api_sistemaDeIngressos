package com.example.demo.service;

import com.example.demo.repository.SalaRepository;
import com.example.demo.repository.entity.Sala;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public List<Sala> findAll() { return repository.findAll(); }
    public Optional<Sala> findById(Long id) { return repository.findById(id); }
    public Sala save(Sala sala) { return repository.save(sala); }
    public void delete(Long id) { repository.deleteById(id); }
}
