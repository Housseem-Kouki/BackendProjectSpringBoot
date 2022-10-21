package com.example.backendproject.services;

import com.example.backendproject.entities.Departement;

import java.util.List;

public interface IDepartementService {
    public List<Departement> getAllDepartements();
    public Departement getDepartementById(int id);
    public Departement addDepartement(Departement departement);
    public Departement updateDepartement(Departement departement);
    public void deleteDepartement(int id);
}
