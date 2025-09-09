package com.example.demo.controller;

import com.example.demo.repository.entity.Ingresso;
import com.example.demo.service.IngressoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {
    private final IngressoService service;

    public IngressoController(IngressoService service) { this.service = service; }

    @GetMapping
    public List<Ingresso> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Ingresso> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ingresso create(@RequestBody Ingresso ingresso) { return service.save(ingresso); }

    @PutMapping("/{id}")
    public ResponseEntity<Ingresso> update(@PathVariable Long id, @RequestBody Ingresso ingresso) {
        return service.findById(id).map(existing -> {
            existing.setPreco(ingresso.getPreco());
            existing.setCliente(ingresso.getCliente());
            existing.setSessao(ingresso.getSessao());
            existing.setAssento(ingresso.getAssento());
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
