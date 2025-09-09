package com.example.demo.controller;

import com.example.demo.repository.entity.Filme;
import com.example.demo.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeService service;

    public FilmeController(FilmeService service) { this.service = service; }

    @GetMapping
    public List<Filme> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Filme create(@RequestBody Filme filme) { return service.save(filme); }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> update(@PathVariable Long id, @RequestBody Filme filme) {
        return service.findById(id).map(existing -> {
            existing.setTitulo(filme.getTitulo());
            existing.setGenero(filme.getGenero());
            existing.setDuracao(filme.getDuracao());
            existing.setClassificacaoEtaria(filme.getClassificacaoEtaria());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id).map(existing -> {
            service.delete(id);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
