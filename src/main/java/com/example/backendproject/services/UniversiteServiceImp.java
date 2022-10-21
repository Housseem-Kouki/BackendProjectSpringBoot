package com.example.backendproject.services;

import com.example.backendproject.entities.Universite;
import com.example.backendproject.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversiteServiceImp implements IUniversiteService {
    @Autowired
    UniversiteRepository universiteRepository;
    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(int id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(int id) {
        universiteRepository.deleteById(id);
    }
}
