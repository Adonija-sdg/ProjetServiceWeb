package com.example.isge.ProjetServiceWeb.service;

import com.example.isge.ProjetServiceWeb.entity.Utilisateur;
import com.example.isge.ProjetServiceWeb.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class InscriptionService {


    private UtilisateurRepository utilisateurRepository;


    private PasswordEncoder passwordEncoder;

    // Ajoutez la méthode pour gérer l'inscription
    public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
        // Encoder le mot de passe avant l'enregistrement
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return utilisateurRepository.save(utilisateur);
    }
}
