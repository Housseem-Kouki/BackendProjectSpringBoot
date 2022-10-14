package com.example.backendproject.repository;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
}
