package com.example.backendproject.repository;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.DetailsEquipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsEquipeRepository extends JpaRepository<DetailsEquipe,Long> {
    List<DetailsEquipe> findByThematiqueLike (String thematique);
}
