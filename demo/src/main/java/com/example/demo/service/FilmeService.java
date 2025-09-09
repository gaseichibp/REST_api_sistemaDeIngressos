package com.example.demo.service;

import com.example.demo.repository.FilmeRepository;
import com.example.demo.repository.entity.Filme;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public List<Filme> findAll() { return repository.findAll(); }
    public Optional<Filme> findById(Long id) { return repository.findById(id); }
    public Filme save(Filme filme) { return repository.save(filme); }
    public void delete(Long id) { repository.deleteById(id); }
}
