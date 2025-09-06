package com.example.demo.repository.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 20)
    private String genero;

    @Column(nullable = false)
    private Integer duracao; // minutos

    @Column(nullable = false, length = 5)
    private String classificacaoEtaria;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sessao> sessoes;

    public Filme() {}

    public Filme(String titulo, String genero, Integer duracao, String classificacaoEtaria) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracao() {
        return duracao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getClassificacaoEtaria() {
        return classificacaoEtaria;
    }
    public void setClassificacaoEtaria(String classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }
    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

}





