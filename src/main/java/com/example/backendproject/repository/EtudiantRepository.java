package com.example.backendproject.repository;

import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Etudiant findByPrenomEContains(String prenomE);

    @Query("SELECT et FROM Etudiant et , Equipe eq , DetailsEquipe dq where  dq.thematique =? 1  ")
    List<Etudiant> retrieveEtudiantByEquipeThematique (@PathVariable("thematique") String thematique);


    @Modifying
    @Query("update Etudiant et set et.opt =? 1 where et.idEtudiant =? 2 ")
    void updateEtudiantByOption(@PathVariable("option") Option option , @PathVariable("idEtudiant") int idEtudiant);

}
