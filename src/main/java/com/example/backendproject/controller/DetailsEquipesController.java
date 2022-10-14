package com.example.backendproject.controller;


import com.example.backendproject.entities.DetailsEquipe;
import com.example.backendproject.services.IDetailsEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailsEquipesController {
    @Autowired
    IDetailsEquipeService iDetailsEquipeService;

    @GetMapping("/AllDetailsEquipes")
    @ResponseBody
    public List<DetailsEquipe> getAllDetailsEquipes(){
        return iDetailsEquipeService.getAllDetailsEquipe();
    }

    @PostMapping("/addDetailsEquipe")
    @ResponseBody
    public DetailsEquipe addDetailsEquipe(@RequestBody DetailsEquipe detailsEquipe){
        return iDetailsEquipeService.addDetailsEquipe(detailsEquipe);
    }


    @PutMapping("/updateDetailsEquipe")
    @ResponseBody
    public DetailsEquipe updateDetailsEquipe(@RequestBody DetailsEquipe detailsEquipe){
        return iDetailsEquipeService.updateDetailsEquipe(detailsEquipe);
    }


    @DeleteMapping("/deleteDetailsEquipe/{id}")
    @ResponseBody
    public void deleteDetailsEquipe(@PathVariable("id")long id){
        iDetailsEquipeService.deleteDetailsEquipe(id);
    }

    @GetMapping("/getDetailsEquipeById/{id}")
    @ResponseBody
    public DetailsEquipe getDetailsEquipeById(@PathVariable("id")long id){
        return iDetailsEquipeService.getDetailsEquipeById(id);
    }

}
