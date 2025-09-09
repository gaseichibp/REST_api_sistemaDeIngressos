package com.example.demo.service;

import com.example.demo.repository.IngressoRepository;
import com.example.demo.repository.entity.Ingresso;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngressoService {
    private final IngressoRepository repository;

    public IngressoService(IngressoRepository repository) { this.repository = repository; }

    public List<Ingresso> findAll() { return repository.findAll(); }
    public Optional<Ingresso> findById(Long id) { return repository.findById(id); }
    public Ingresso save(Ingresso ingresso) { return repository.save(ingresso); }
    public void delete(Long id) { repository.deleteById(id); }
}
