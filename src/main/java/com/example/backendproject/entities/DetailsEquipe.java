package com.example.backendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailsEquipe   implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idDetailsEquipe;
    private Integer salle;
    private String thematique;

    @OneToOne(mappedBy = "detailsequipe")
    private  Equipe equipe;
}
