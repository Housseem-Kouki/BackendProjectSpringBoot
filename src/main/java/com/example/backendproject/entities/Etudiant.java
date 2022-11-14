package com.example.backendproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int idEtudiant ;

    private String prenomE ;

    private String nomE ;
    
    @Enumerated(EnumType.STRING)
    private Option opt ;

    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;

    @ManyToMany(mappedBy = "etudiant" ,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonIgnore
    private  Set<Equipe> equipes;


}
