package com.example.isge.ProjetServiceWeb.repository;

import com.example.isge.ProjetServiceWeb.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);

    Optional<Utilisateur> findByEmail(String username);
}
