package com.example.backendproject.services;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContratServiceImp implements IContratService{
    @Autowired
    ContratRepository contratRepository;

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratById(long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(long id) {
        contratRepository.deleteById(id);
    }
}
