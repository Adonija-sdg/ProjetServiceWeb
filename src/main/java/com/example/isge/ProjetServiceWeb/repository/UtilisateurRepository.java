package com.example.isge.ProjetServiceWeb.repository;

import com.example.isge.ProjetServiceWeb.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);
}
