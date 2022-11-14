package com.example.backendproject.repository;

import com.example.backendproject.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    List<Contrat> findContratByEtudiantIdEtudiant(int idEtudiant);

    @Query("SELECT  c FROM Contrat c where  c.dateDebutC >=? 1 and c.dateFinC <=? 2 ")
    List<Contrat> ListContratBetweenToDate(@PathVariable("dateD")Date dateD , @PathVariable("dateF")Date dateF);


}
