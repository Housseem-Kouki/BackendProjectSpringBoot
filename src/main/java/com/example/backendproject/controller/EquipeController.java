package com.example.backendproject.controller;


import com.example.backendproject.entities.Equipe;
import com.example.backendproject.services.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipeController {
    @Autowired
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
    public void deleteEquipe(@PathVariable("id")long id){
        iEquipeService.deleteEquipe(id);
    }

    @GetMapping("/getEquipeById/{id}")
    @ResponseBody
    public Equipe getEquipeById(@PathVariable("id")long id){
        return iEquipeService.getEquipeById(id);
    }
}
