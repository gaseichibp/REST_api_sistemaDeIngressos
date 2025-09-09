package com.example.demo.repository;

import com.example.demo.repository.entity.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long> {}
