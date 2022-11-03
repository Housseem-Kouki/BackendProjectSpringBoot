package com.example.backendproject.controller;


import com.example.backendproject.entities.Equipe;
import com.example.backendproject.entities.Niveau;
import com.example.backendproject.services.IEquipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeController {

    IEquipeService iEquipeService;



    @GetMapping("/AllEquipes")
    @ResponseBody
    public List<Equipe> getAllEquipes(){
        return iEquipeService.getAllEquipes();
    }

    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return iEquipeService.addEquipe(equipe);
    }


    @PutMapping("/updateEquipe")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe equipe){
        return iEquipeService.updateEquipe(equipe);
    }


    @DeleteMapping("/deleteEquipe/{id}")
    @ResponseBody
    public void deleteEquipe(@PathVariable("id")int id){
        iEquipeService.deleteEquipe(id);
    }

    @GetMapping("/getEquipeById/{id}")
    @ResponseBody
    public Equipe getEquipeById(@PathVariable("id")int id){
        return iEquipeService.getEquipeById(id);
    }


    @GetMapping("/getListEquipeEtudiant/{idEtudiant}")
    @ResponseBody
    public List<Equipe> getListEquipeEtudiant(@PathVariable("idEtudiant") int idEtudiant ){
        return iEquipeService.findByEtudiantIdEtudiant(idEtudiant);
    }

    @GetMapping("/getListEquipeEtudiantThematiqueNotNull/{idEtudiant}")
    @ResponseBody
    public List<Equipe>findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(@PathVariable("idEtudiant") int idEtudiant){
        return iEquipeService.findByEtudiantIdEtudiantAndDetailsequipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/ListEquipeEtudAndDepartement")
    @ResponseBody
    public   List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepartement(@RequestParam("idEtudiant") int idEtudiant, @RequestParam("idDepart")  int idDepart){
        return iEquipeService.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant,idDepart);
    }


    @GetMapping("/retriveEquipeByNiveauAndThematique/{niveau}/{thematique}")
    @ResponseBody
    public   List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau, @PathVariable("thematique")  String thematique){
        return iEquipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @DeleteMapping("/deleteEquipeByNiveau/{niveau}")
    @ResponseBody
    public void deleteEquipeByNiveau( @PathVariable("niveau") Niveau niveau){
        iEquipeService.deleteEquipeByNiveau(niveau);
    }
}


