package com.example.backendproject.repository;

import com.example.backendproject.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}
