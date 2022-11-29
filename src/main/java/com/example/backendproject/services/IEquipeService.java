package com.example.backendproject.services;

import com.example.backendproject.entities.Equipe;
import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.entities.Niveau;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IEquipeService {
    public List<Equipe> getAllEquipes();
    public Equipe getEquipeById(int id);
    public Equipe addEquipe(Equipe equipe);
    public Equipe updateEquipe(Equipe equipe);
    public void deleteEquipe(int id);

    public List<Equipe> findByEtudiantIdEtudiant (int idEtudiant);

    public List<Equipe>findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(int idEtudiant);

    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(int idEtudiant,int idDepart);

    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau ,String thematique);

    void deleteEquipeByNiveau( Niveau niveau);


    void faireEvoluerEquipes();
}
