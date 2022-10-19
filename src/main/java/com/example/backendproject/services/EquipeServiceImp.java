package com.example.backendproject.services;

import com.example.backendproject.entities.Equipe;
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
    public Equipe getEquipeById(long id) {
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
    public void deleteEquipe(long id) {
        equipeRepository.deleteById(id);
    }
}
