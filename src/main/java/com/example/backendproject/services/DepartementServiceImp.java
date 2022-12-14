package com.example.backendproject.services;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.entities.Option;
import com.example.backendproject.entities.Universite;
import com.example.backendproject.repository.DepartementRepository;
import com.example.backendproject.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DepartementServiceImp implements IDepartementService {
    //injecter repository dans service
    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(int id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public Departement addDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(int id) {
        departementRepository.deleteById(id);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option option) {
        return departementRepository.retrieveDepartementByOptionEtudiant(option);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        List<Departement> ListDep = new ArrayList<>(u.getDepartements());
        return ListDep;
    }
}
