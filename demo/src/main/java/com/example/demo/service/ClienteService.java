package com.example.demo.service;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.entity.Cliente;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
