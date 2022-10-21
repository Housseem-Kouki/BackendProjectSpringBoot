package com.example.backendproject.controller;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.services.IDepartementService;
import com.example.backendproject.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DepartementController {

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
    public void deleteDepartement(@PathVariable("id")int id){
        iDepartementService.deleteDepartement(id);
    }

    @GetMapping("/getDepartementById/{id}")
    @ResponseBody
    public Departement getDepartementById(@PathVariable("id")int id){
        return iDepartementService.getDepartementById(id);
    }

}
