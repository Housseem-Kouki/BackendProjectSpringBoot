package com.example.backendproject.services;

import com.example.backendproject.entities.*;
import com.example.backendproject.repository.ContratRepository;
import com.example.backendproject.repository.DepartementRepository;
import com.example.backendproject.repository.EquipeRepository;
import com.example.backendproject.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImp implements  IEtudiantService {
    //injecter repository dans service

    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;

    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
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

    @Override
    public void assignEtudiantToDepartement(int etudiantId, int departementId) {

        Etudiant e = etudiantRepository.findById(etudiantId).orElse(null);
        Departement d =departementRepository.findById(departementId).orElse(null);
        e.setDepartement(d);
        etudiantRepository.save(e);

    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int idEquipe) {
        Contrat c = contratRepository.findById(idContrat).orElse(null);
        Equipe eq = equipeRepository.findById(idEquipe).orElse(null);
        c.setEtudiant(e);
        eq.getEtudiant().add(e);
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(int idDepartement) {
        return etudiantRepository.findEtudiantByDepartementIdDepartement(idDepartement);
    }


}
