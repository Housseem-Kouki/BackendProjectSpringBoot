package com.example.backendproject.controller;

import com.example.backendproject.entities.Contrat;
import com.example.backendproject.services.IContratService;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ContratController {

    IContratService iContratService;


    @GetMapping("/AllContrats")
    @ResponseBody
    public List<Contrat> getAllContrats(){
        return iContratService.getAllContrats();
    }

    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat addContrat(@RequestBody Contrat contrat){
        return iContratService.addContrat(contrat);
    }


    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat contrat){
        return iContratService.updateContrat(contrat);
    }


    @DeleteMapping("/deleteContrat/{id}")
    @ResponseBody
    public void deleteContrat(@PathVariable("id")int id){
        iContratService.deleteContrat(id);
    }

    @GetMapping("/getContratById/{id}")
    @ResponseBody
    public Contrat getContratById(@PathVariable("id")int id){
        return iContratService.getContratById(id);
    }

    @PostMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant (@RequestBody Contrat ce,@PathVariable("nomE")String nomE ,@PathVariable("prenomE")String prenomE ){
        return iContratService.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("/getChiffreAffaireEntreDeuxDate")
    public float getChiffreAffaireEntreDeuxDate(@RequestParam("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") Date endDate){
     return  iContratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }


    @GetMapping("/nbContratsValides")
    Integer nbContratsValides(@RequestParam("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date startDate,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate")  Date endDate){

        return iContratService.nbContratsValides(startDate,endDate);
    }

}
