package com.example.demo.controller;

import com.example.demo.repository.entity.Sessao;
import com.example.demo.service.SessaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    private final SessaoService service;

    public SessaoController(SessaoService service) { this.service = service; }

    @GetMapping
    public List<Sessao> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Sessao> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sessao create(@RequestBody Sessao sessao) { return service.save(sessao); }

    @PutMapping("/{id}")
    public ResponseEntity<Sessao> update(@PathVariable Long id, @RequestBody Sessao sessao) {
        return service.findById(id).map(existing -> {
            existing.setData(sessao.getData());
            existing.setHora(sessao.getHora());
            existing.setFilme(sessao.getFilme());
            existing.setSala(sessao.getSala());
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
