package com.example.backendproject.services;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.entities.Option;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartementService {
    public List<Departement> getAllDepartements();
    public Departement getDepartementById(int id);
    public Departement addDepartement(Departement departement);
    public Departement updateDepartement(Departement departement);
    public void deleteDepartement(int id);
    List<Departement> retrieveDepartementByOptionEtudiant(Option option);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
