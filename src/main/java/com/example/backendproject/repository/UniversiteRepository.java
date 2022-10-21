package com.example.backendproject.repository;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
}
