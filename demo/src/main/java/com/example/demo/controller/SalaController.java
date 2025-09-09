package com.example.demo.controller;

import com.example.demo.repository.entity.Sala;
import com.example.demo.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {
    private final SalaService service;

    public SalaController(SalaService service) { this.service = service; }

    @GetMapping
    public List<Sala> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sala create(@RequestBody Sala sala) { return service.save(sala); }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> update(@PathVariable Long id, @RequestBody Sala sala) {
        return service.findById(id).map(existing -> {
            existing.setNumero(sala.getNumero());
            existing.setCapacidade(sala.getCapacidade());
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
