package com.example.backendproject.services;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.entities.Specialite;
import com.example.backendproject.repository.ContratRepository;
import com.example.backendproject.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
    public String getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float chiffre=0;
        float chiffreIA=0;
        float chiffreRESAUX=0;
        float chiffreCLOUD=0;
        float chiffreSECURITE=0;
        List<Contrat> lc = contratRepository.ListContratBetweenToDate(startDate,endDate);
        for(Contrat c : lc){

            if(c.getSpecialite().toString().equals("IA")){
                chiffreIA = chiffreIA + c.getMontantC();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("CLOUD")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantC();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("SECURITE")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantC();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("RESEAUX")){
                chiffreRESAUX = chiffreRESAUX + c.getMontantC();
                System.out.println("******** Ia ="+chiffreIA);
            }
            chiffre = chiffre + c.getMontantC();

        }
        String ch ="Pour un contrat dont la spécialité est IA: "+chiffreIA+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est RESEAUX: "+chiffreRESAUX+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est CLOUD: "+chiffreCLOUD+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est SECURITE: "+chiffreSECURITE+"Dt/mois\n";
        return ch;
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

    @Override
    public String retrieveAndUpdateStatusContrat() {

        return null;
    }


    @Scheduled(fixedRate = 60000)
    // @Scheduled(cron = "* * * 13 * * *")
    public void fixedRateMethod() {

        List<Contrat> contrats = contratRepository.ListeContratsApres15Jours();
        String string ="" ;
        for (Contrat c : contrats){

          string += string +"id : " + c.getIdContrat()  +"\n"+
                  " date fin" +c.getDateFinC()+"\n"
                  +"Etudiant" + c.getEtudiant().getNomE()+"\n"
                  +  "specialite" + c.getSpecialite()+"\n" ;

         //   c.setArchive(true);
        }
        System.out.println("les contrats = "+string);

    }


}
