package com.example.backendproject.repository;

import com.example.backendproject.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Etudiant findByPrenomEContains(String prenomE);

}
