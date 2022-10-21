package com.example.backendproject.services;

import com.example.backendproject.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> getAllEtudiants();
    public Etudiant getEtudiantById(int id);
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public void deleteEtudiant(int id);
    public Etudiant findPrenomEContains(String prenomE);
}
