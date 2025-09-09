package com.example.demo.repository;

import com.example.demo.repository.entity.Assento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssentoRepository extends JpaRepository<Assento, Long> {}
