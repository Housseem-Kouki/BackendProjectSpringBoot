package com.example.backendproject.controller;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.services.IDepartementService;
import com.example.backendproject.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementController {
    @Autowired
    IDepartementService iDepartementService;

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello departement";
    }

    @GetMapping("/AllDepartements")
    @ResponseBody
    public List<Departement> getAllDepartements(){
        return iDepartementService.getAllDepartements();
    }

    @PostMapping("/addDepartement")
    @ResponseBody
    public Departement addDepartement(@RequestBody Departement departement){
        return iDepartementService.addDepartement(departement);
    }


    @PutMapping("/updateDepartement")
    @ResponseBody
    public Departement updateDeaprtement(@RequestBody Departement departement){
        return iDepartementService.updateDepartement(departement);
    }


    @DeleteMapping("/deleteDepartement/{id}")
    @ResponseBody
    public void deleteDepartement(@PathVariable("id")long id){
        iDepartementService.deleteDepartement(id);
    }

    @GetMapping("/getDepartementById/{id}")
    @ResponseBody
    public Departement getDepartementById(@PathVariable("id")long id){
        return iDepartementService.getDepartementById(id);
    }

}
