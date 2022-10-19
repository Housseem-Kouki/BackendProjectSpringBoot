package com.example.backendproject.controller;


import com.example.backendproject.entities.Universite;
import com.example.backendproject.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;

    @GetMapping("/AllUniversites")
    @ResponseBody
    public List<Universite> getAllUniversites(){
        return iUniversiteService.getAllUniversites();
    }

    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite universite){
        return iUniversiteService.addUniversite(universite);
    }


    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite universite){
        return iUniversiteService.updateUniversite(universite);
    }


    @DeleteMapping("/deleteUniversite/{id}")
    @ResponseBody
    public void deleteUniversite(@PathVariable("id")long id){
        iUniversiteService.deleteUniversite(id);
    }

    @GetMapping("/getUniversiteById/{id}")
    @ResponseBody
    public Universite getUniversiteById(@PathVariable("id")long id){
        return iUniversiteService.getUniversiteById(id);
    }


}
