package com.example.backendproject.services;

import com.example.backendproject.entities.Equipe;


import java.util.List;

public interface IEquipeService {
    public List<Equipe> getAllEquipes();
    public Equipe getEquipeById(long id);
    public Equipe addEquipe(Equipe equipe);
    public Equipe updateEquipe(Equipe equipe);
    public void deleteEquipe(long id);
}
