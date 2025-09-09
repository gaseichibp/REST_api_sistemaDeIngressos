package com.example.demo.controller;

import com.example.demo.repository.entity.Assento;
import com.example.demo.service.AssentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/assentos")
public class AssentoController {
    private final AssentoService service;

    public AssentoController(AssentoService service) { this.service = service; }

    @GetMapping
    public List<Assento> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Assento> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Assento create(@RequestBody Assento assento) { return service.save(assento); }

    @PutMapping("/{id}")
    public ResponseEntity<Assento> update(@PathVariable Long id, @RequestBody Assento assento) {
        return service.findById(id).map(existing -> {
            existing.setNumero(assento.getNumero());
            existing.setSala(assento.getSala());
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
