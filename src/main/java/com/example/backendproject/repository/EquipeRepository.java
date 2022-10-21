package com.example.backendproject.repository;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {

    List<Equipe> findByEtudiantIdEtudiant (int idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(Integer idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepartement (Integer idEtudiant, Integer idDepart);


}
