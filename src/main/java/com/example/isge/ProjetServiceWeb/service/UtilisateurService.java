package com.example.isge.ProjetServiceWeb.service;

import com.example.isge.ProjetServiceWeb.dto.UtilisateurDto;
import org.springframework.transaction.annotation.Transactional;
import com.example.isge.ProjetServiceWeb.entity.Role;
import com.example.isge.ProjetServiceWeb.entity.Utilisateur;
import com.example.isge.ProjetServiceWeb.mapper.UtilisateurDtoMapper;
import com.example.isge.ProjetServiceWeb.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void enregistrementDansLaBaseDonnees(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = UtilisateurDtoMapper.toUtilisateur(utilisateurDto);
//        if (!utilisateurDto.getEmail().contains("@") || !utilisateurDto.getEmail().contains(".")) {
//            throw new RuntimeException("Votre mail invalide");
//        }
        String motDePasseCrypte = this.passwordEncoder.encode(utilisateurDto.getMotDePasse());
        utilisateur.setMotDePasse(motDePasseCrypte);

        utilisateurRepository.save(utilisateur);
    }

    public void retirerDeLaBaseDeDonnee(long id) {
        utilisateurRepository.deleteById(id);
    }

    public void modificationDansLaBaseDeDonnees(Long id, UtilisateurDto utilisateurDto) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setUsername(utilisateurDto.getUsername());
            utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
            utilisateurRepository.save(utilisateur);
        } else {
            throw new RuntimeException("Utilisateur non trouvé");
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
