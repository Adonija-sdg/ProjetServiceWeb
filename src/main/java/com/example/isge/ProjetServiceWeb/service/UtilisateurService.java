package com.example.isge.ProjetServiceWeb.service;

import com.example.isge.ProjetServiceWeb.dto.UtilisateurDto;
import com.example.isge.ProjetServiceWeb.entity.Utilisateur;
import com.example.isge.ProjetServiceWeb.mapper.UtilisateurDtoMapper;
import com.example.isge.ProjetServiceWeb.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    public void enregistrementDansLaBaseDonnees(UtilisateurDto utilisateurdto) {
        Utilisateur utilisateur = UtilisateurDtoMapper.toUtilisateur(utilisateurdto);
        utilisateurRepository.save(utilisateur);
    }

    public void retirerDeLaBaseDeDonnee(long id) {

        utilisateurRepository.deleteById(id);
    }


    public void modificationDansLaBaseDeDonnees(Long id, UtilisateurDto utilisateurDto) {
        // Recherche de l'utilisateur par ID
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            // Mettre à jour les informations de l'utilisateur avec les données du DTO
            utilisateur.setUsername(utilisateurDto.getUsername());
            utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
            // Mettre à jour d'autres attributs si nécessaire
            utilisateurRepository.save(utilisateur);
        } else {
            // Gérer le cas où l'utilisateur n'est pas trouvé
            // Vous pouvez lever une exception ou gérer autrement selon votre logique métier
        }
    }

    public UtilisateurDto obtenirUtilisateurParId(Long id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        return optionalUtilisateur.map(UtilisateurDtoMapper::toUtilisateurDto).orElse(null);
    }

    public List<UtilisateurDto> obtenirTousLesUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(UtilisateurDtoMapper::toUtilisateurDto)
                .collect(Collectors.toList());
    }
}
