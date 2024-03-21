package com.example.isge.ProjetServiceWeb.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class CorrectionParJour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_correction;
    
    private float valeurCorrection;
    
    private LocalDate dateSaisie;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


}
