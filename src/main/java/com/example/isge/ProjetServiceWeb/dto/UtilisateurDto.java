package com.example.isge.ProjetServiceWeb.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UtilisateurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String roles;
    private String motDePasse;

    private UtilisateurDto utilisateurDto;

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
    }
}
