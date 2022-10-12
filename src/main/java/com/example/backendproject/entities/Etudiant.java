package com.example.backendproject.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant ;

    private String prenomE ;

    private String nomE ;
    
    @Enumerated(EnumType.STRING)
    private Option opt ;

    @ManyToOne
    private Departement departement;

    @OneToMany(mappedBy = "etudiant")
    private Set<Contrat> contrats;

    @ManyToMany
    private  Set<Equipe> equipes;


}
