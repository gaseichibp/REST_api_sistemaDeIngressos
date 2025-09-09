package com.example.demo.service;

import com.example.demo.repository.AssentoRepository;
import com.example.demo.repository.entity.Assento;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssentoService {
    private final AssentoRepository repository;

    public AssentoService(AssentoRepository repository) { this.repository = repository; }

    public List<Assento> findAll() { return repository.findAll(); }
    public Optional<Assento> findById(Long id) { return repository.findById(id); }
    public Assento save(Assento assento) { return repository.save(assento); }
    public void delete(Long id) { repository.deleteById(id); }
}
