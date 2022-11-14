package com.example.backendproject.services;

import com.example.backendproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> getAllUniversites();
    public Universite getUniversiteById(int id);
    public Universite addUniversite(Universite universite);
    public Universite updateUniversite(Universite universite);
    public void deleteUniversite(int id);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
