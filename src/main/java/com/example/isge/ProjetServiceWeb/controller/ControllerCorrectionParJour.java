package com.example.isge.ProjetServiceWeb.controller;

import com.example.isge.ProjetServiceWeb.dto.CorrectionParJourDto; // Importer CorrectionParJourDto
import com.example.isge.ProjetServiceWeb.dto.UtilisateurDto;
import com.example.isge.ProjetServiceWeb.service.CorrectionParJourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/corrections")
public class ControllerCorrectionParJour {

    private final CorrectionParJourService correctionParJourService;

    public ControllerCorrectionParJour(CorrectionParJourService correctionParJourService){
        this.correctionParJourService = correctionParJourService;
    }

    // Ajoutez la méthode pour gérer l'authentification
    @PostMapping("/creationCorrection")
    @ResponseBody
    public String creationCorrection(@RequestBody CorrectionParJourDto correctionParJourDto) {
        correctionParJourService.enregistrementDansLaBaseDonnees(correctionParJourDto);
        return "Correction créé avec succès";
    }

    @PutMapping("/update/{id_correction}")
    @ResponseBody
    public String modificationUtilisateur(@PathVariable Long id_correction, @RequestBody CorrectionParJourDto correctionParJourDto) {
        correctionParJourService.modificationDansLaBaseDeDonnees(id_correction, correctionParJourDto);
        return "Utilisateur modifié avec succès";
    }

    @DeleteMapping("/delete/{id_correction}")
    @ResponseBody
    public String suppressionCorrection(@PathVariable Long id_correction) {
        correctionParJourService.retirerDeLaBaseDeDonnee(id_correction);
        return "Correction supprimée avec succès";
    }

    @GetMapping("/get/{id_correction}")
    @ResponseBody
    public CorrectionParJourDto obtenirUtilisateurParId(@PathVariable Long id) {
        return correctionParJourService.obtenirUtilisateurParId(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<CorrectionParJourDto> obtenirTousLesUtilisateurs() {
        return correctionParJourService.obtenirTousLesUtilisateurs();
    }
}
