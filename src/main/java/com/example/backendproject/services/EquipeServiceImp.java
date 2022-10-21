package com.example.backendproject.services;

import com.example.backendproject.entities.Equipe;
import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeServiceImp implements IEquipeService{

    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipeById(int id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public void deleteEquipe(int id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiant(int idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(int idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(int idEtudiant, int idDepart) {
        return equipeRepository.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepartement(idEtudiant,idDepart);
    }


}
