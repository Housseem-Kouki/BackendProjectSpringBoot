package com.example.backendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContrat ;
    @Temporal(TemporalType.DATE)
    private Date dateDebutC ;
    @Temporal(TemporalType.DATE)
    private Date dateFinC ;
    @Enumerated(EnumType.STRING)
    private Specialite specialite ;
    private Boolean archive ;
    private  Float montantC;

    @ManyToOne
    private Etudiant etudiant;
}
