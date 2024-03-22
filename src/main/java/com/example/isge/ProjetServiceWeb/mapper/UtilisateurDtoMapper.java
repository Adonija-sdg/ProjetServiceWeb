package com.example.isge.ProjetServiceWeb.mapper;

import com.example.isge.ProjetServiceWeb.dto.UtilisateurDto;
import com.example.isge.ProjetServiceWeb.entity.Utilisateur;

public class UtilisateurDtoMapper {

    public static UtilisateurDto toUtilisateurDto(Utilisateur utilisateur) {
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setNom(utilisateur.getNom());
        utilisateurDto.setUsername(utilisateur.getUsername());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        utilisateurDto.setEmail(utilisateur.getEmail());
        utilisateurDto.setRoles(utilisateur.getRoles());

        return utilisateurDto;
    }

    public static Utilisateur toUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setUsername(utilisateurDto.getUsername());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setRoles(utilisateurDto.getRoles());

        return utilisateur;
    }
}