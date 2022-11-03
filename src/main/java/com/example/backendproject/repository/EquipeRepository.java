package com.example.backendproject.repository;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.Equipe;
import com.example.backendproject.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface EquipeRepository extends JpaRepository<Equipe,Integer> {

    List<Equipe> findByEtudiantIdEtudiant (int idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(Integer idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepartement (Integer idEtudiant, Integer idDepart);

    @Query("SELECT eq FROM Equipe eq , DetailsEquipe dq where eq.detailsequipe.idDetailsEquipe = dq.idDetailsEquipe and  eq.niveau =? 1 and dq.thematique =? 2 ")
    List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau , @Param("thematique") String thematique);

    @Modifying
    @Query("DELETE FROM Equipe e where e.niveau =? 1")
    void deleteEquipeByNiveau( @Param("niveau") Niveau niveau);
}
