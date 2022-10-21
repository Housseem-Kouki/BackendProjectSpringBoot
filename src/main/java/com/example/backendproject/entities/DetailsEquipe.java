package com.example.backendproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private  int idDetailsEquipe;
    private Integer salle;
    private String thematique;
    @JsonIgnore
    @OneToOne(mappedBy = "detailsequipe" , cascade = CascadeType.ALL)
    private  Equipe equipe;
}
