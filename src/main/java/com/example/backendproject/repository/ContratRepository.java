package com.example.backendproject.repository;

import com.example.backendproject.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
}
