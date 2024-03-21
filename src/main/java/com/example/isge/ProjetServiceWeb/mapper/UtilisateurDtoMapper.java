package com.example.isge.ProjetServiceWeb.mapper;

import com.example.isge.ProjetServiceWeb.dto.UtilisateurDto;
import com.example.isge.ProjetServiceWeb.entity.Utilisateur;

public class UtilisateurDtoMapper {

    public static UtilisateurDto toUtilisateurDto(Utilisateur utilisateur) {
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setUsername(utilisateur.getUsername());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        // Vous pouvez ajouter d'autres mappings selon vos besoins
        return utilisateurDto;
    }

    public static Utilisateur toUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(utilisateurDto.getUsername());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        // Vous pouvez ajouter d'autres mappings selon vos besoins
        return utilisateur;
    }
}