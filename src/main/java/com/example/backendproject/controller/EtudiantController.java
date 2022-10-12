package com.example.backendproject.controller;

import com.example.backendproject.entities.Etudiant;
import com.example.backendproject.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {

    @Autowired
    IEtudiantService iEtudiantService;

    @GetMapping
    public String SayHello(){
        return "Hello";
    }

    @GetMapping("/AllEtudiant")
    @ResponseBody
    public List<Etudiant> getAllEtudiant(){
        return iEtudiantService.getAllEtudiants();
    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant addEtudiant (@RequestBody Etudiant etudiant){
        return iEtudiantService.addEtudiant(etudiant);
    }



    @PutMapping("/updateEtudiant")
    private Etudiant updateEtudiant(@RequestBody Etudiant etudiant)
    {
        iEtudiantService.updateEtudiant(etudiant);
        return etudiant;
    }



    @DeleteMapping("/deleteEtudiant/{id}")
    private void deleteEtudiant(@PathVariable("id") int id)
    {
        iEtudiantService.deleteEtudiant(id);
    }

    @GetMapping("/getEtudiantById/{id}")
    @ResponseBody
    public void  getEtudiantById(@PathVariable("id") int id){
        iEtudiantService.getEtudiantById(id);
    }




}
