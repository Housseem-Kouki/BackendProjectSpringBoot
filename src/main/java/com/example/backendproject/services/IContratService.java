package com.example.backendproject.services;

import com.example.backendproject.entities.Contrat;


import java.util.List;

public interface IContratService {
    public List<Contrat> getAllContrats();
    public Contrat getContratById(long id);
    public Contrat addContrat(Contrat contrat);
    public Contrat updateContrat(Contrat contrat);
    public void deleteContrat(long id);
}