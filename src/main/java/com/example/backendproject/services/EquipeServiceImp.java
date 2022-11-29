package com.example.backendproject.services;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.Equipe;
import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.entities.Niveau;
import com.example.backendproject.repository.ContratRepository;
import com.example.backendproject.repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EquipeServiceImp implements IEquipeService{

    EquipeRepository equipeRepository;
    ContratRepository contratRepository;

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipeById(int id) {
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
    public void deleteEquipe(int id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiant(int idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(int idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(int idEtudiant, int idDepart) {
        return equipeRepository.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepartement(idEtudiant,idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void faireEvoluerEquipes() {
        List<Equipe> equipes = equipeRepository.findAll();
        List<Contrat> contratDepasseAn = contratRepository.contratDepasseAn();
        // contrat depasse un an
        int cValid = 0;
        // etudiant d'une equipe ayant contrat valid
        int eValid = 0;
        for (Equipe e : equipes){
            if (e.getEtudiant().size()>=3 ){
                for(Etudiant etudiant : e.getEtudiant()){
                    Set<Contrat> lc = etudiant.getContrats();
                    for (Contrat contrat : lc){
                        if (contratDepasseAn.contains(contrat)){
                            cValid += cValid +1;
                            eValid++;
                        }
                    }

                }


                }

            if (eValid>=3&& e.getNiveau()==Niveau.JUNIOR) {
                e.setNiveau(Niveau.SENIOR);
                equipeRepository.save(e);
            } else if (cValid>=3&& (e.getNiveau()==Niveau.SENIOR)) {
                e.setNiveau(Niveau.EXPERT);
                equipeRepository.save(e);
            }
            }



        }



}
