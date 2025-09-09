package com.example.demo.service;

import com.example.demo.repository.SessaoRepository;
import com.example.demo.repository.entity.Sessao;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {
    private final SessaoRepository repository;

    public SessaoService(SessaoRepository repository) { this.repository = repository; }

    public List<Sessao> findAll() { return repository.findAll(); }
    public Optional<Sessao> findById(Long id) { return repository.findById(id); }
    public Sessao save(Sessao sessao) { return repository.save(sessao); }
    public void delete(Long id) { repository.deleteById(id); }
}
