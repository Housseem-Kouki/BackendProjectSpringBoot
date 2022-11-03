package com.example.backendproject.services;

import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.entities.Option;
import com.example.backendproject.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImp implements  IEtudiantService {
    //injecter repository dans service

    EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(int id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(int id) {
    etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant findPrenomEContains(String prenomE) {
        return etudiantRepository.findByPrenomEContains(prenomE);
    }

    @Override
    public void updateEtudiantByOption(Option option, int idEtudiant) {
        etudiantRepository.updateEtudiantByOption(option , idEtudiant);
    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }
}
