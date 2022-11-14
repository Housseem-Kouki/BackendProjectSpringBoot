package com.example.backendproject.repository;

import com.example.backendproject.entities.Departement;
import com.example.backendproject.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
    @Query("SELECT d FROM Departement d , Etudiant e where d.idDepartement = e.departement.idDepartement and e.opt =? 1 ")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("option") Option option);


}
