package com.example.backendproject.services;

import com.example.backendproject.entities.DetailsEquipe;


import java.util.List;

public interface IDetailsEquipeService {
    public List<DetailsEquipe> getAllDetailsEquipe();
    public DetailsEquipe getDetailsEquipeById(long id);
    public DetailsEquipe addDetailsEquipe(DetailsEquipe detailsEquipe);
    public DetailsEquipe updateDetailsEquipe(DetailsEquipe detailsEquipe);
    public void deleteDetailsEquipe(long id);
}
