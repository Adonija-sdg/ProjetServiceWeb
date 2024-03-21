package com.example.isge.ProjetServiceWeb.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UtilisateurDto {

    private Long id;
    private String username;
    private String motDePasse;

    private UtilisateurDto utilisateurDto;
}
