package com.example.isge.ProjetServiceWeb.controller;


import com.example.isge.ProjetServiceWeb.dto.UtilisateurDto;
import com.example.isge.ProjetServiceWeb.entity.Utilisateur;
import com.example.isge.ProjetServiceWeb.service.UtilisateurService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/utilisateurs")

public class ControllerUtilisateur {
    private final UtilisateurService utilisateurService;
    public ControllerUtilisateur(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    // Ajoutez la méthode pour gérer l'authentification
    @PostMapping("/creationUtilisateur")
    @ResponseBody
    public String creationUtilisateur(@RequestBody UtilisateurDto utilisateurdto) {
        utilisateurService.enregistrementDansLaBaseDonnees(utilisateurdto);
        return "Utilisateur créé avec succès";
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public String modificationUtilisateur(@PathVariable Long id, @RequestBody UtilisateurDto utilisateurDto) {
        utilisateurService.modificationDansLaBaseDeDonnees(id, utilisateurDto);
        return "Utilisateur modifié avec succès";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String suppressionUtilisateur(@PathVariable Long id) {
        utilisateurService.retirerDeLaBaseDeDonnee(id);
        return "Utilisateur supprimé avec succès";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public UtilisateurDto obtenirUtilisateurParId(@PathVariable Long id) {
        return utilisateurService.obtenirUtilisateurParId(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<UtilisateurDto> obtenirTousLesUtilisateurs() {
        return utilisateurService.obtenirTousLesUtilisateurs();
    }

}
