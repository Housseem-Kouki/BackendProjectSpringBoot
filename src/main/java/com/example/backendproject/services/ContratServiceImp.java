package com.example.backendproject.services;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.repository.ContratRepository;
import com.example.backendproject.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ContratServiceImp implements IContratService{

    ContratRepository contratRepository;

    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratById(int id) {
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
    public void deleteContrat(int id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
        List<Contrat> lc =  contratRepository.findContratByEtudiantIdEtudiant(e.getIdEtudiant());
        if(lc.size()<5){
            ce.setEtudiant(e);
        }
        return contratRepository.save(ce);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float chiffre=0;
        List<Contrat> lc = contratRepository.ListContratBetweenToDate(startDate,endDate);
        for(Contrat c : lc){
            chiffre = chiffre + c.getMontantC();
            
        }
        return chiffre;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int nbrContrat = 0;
        List<Contrat> lc = contratRepository.ListContratBetweenToDate(startDate,endDate);
        for(Contrat c : lc){
            if(c.getArchive() != true){
                nbrContrat ++;
            }

        }
        return nbrContrat;
    }


}
