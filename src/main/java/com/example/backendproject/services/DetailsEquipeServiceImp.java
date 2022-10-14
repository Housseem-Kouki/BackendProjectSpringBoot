package com.example.backendproject.services;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.entities.DetailsEquipe;
import com.example.backendproject.entities.Equipe;
import com.example.backendproject.repository.DetailsEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsEquipeServiceImp implements IDetailsEquipeService{
    @Autowired
    DetailsEquipeRepository detailsEquipeRepository;


    @Override
    public List<DetailsEquipe> getAllDetailsEquipe() {
        return  detailsEquipeRepository.findAll();
    }

    @Override
    public DetailsEquipe getDetailsEquipeById(long id) {
        return detailsEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public DetailsEquipe addDetailsEquipe(DetailsEquipe detailsEquipe) {
        return detailsEquipeRepository.save(detailsEquipe);
    }

    @Override
    public DetailsEquipe updateDetailsEquipe(DetailsEquipe detailsEquipe) {
        return  detailsEquipeRepository.save(detailsEquipe);
    }

    @Override
    public void deleteDetailsEquipe(long id) {
        detailsEquipeRepository.deleteById(id);
    }
}
