package com.example.demo.repository.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "assentos")
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    @OneToMany(mappedBy = "assento", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Assento> ingressos;

    public Assento() {}

    public Assento(String numero, Sala sala) {
        this.numero = numero;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Assento> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Assento> ingressos) {
        this.ingressos = ingressos;
    }
}
