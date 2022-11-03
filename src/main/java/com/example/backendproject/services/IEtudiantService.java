package com.example.backendproject.services;

import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.entities.Option;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> getAllEtudiants();
    public Etudiant getEtudiantById(int id);
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public void deleteEtudiant(int id);
    public Etudiant findPrenomEContains(String prenomE);
    void updateEtudiantByOption(Option option , int idEtudiant);

    List<Etudiant> retrieveEtudiantByEquipeThematique (String thematique);
}
