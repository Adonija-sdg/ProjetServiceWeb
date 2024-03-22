package com.example.isge.ProjetServiceWeb.security;


import com.example.isge.ProjetServiceWeb.entity.Utilisateur;
import com.example.isge.ProjetServiceWeb.repository.UtilisateurRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Configuration
public class UtilisateurSecurityService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> user = utilisateurRepository.findByEmail(username);
        return user.map(UtilisateurSecurity::new)
                .orElseThrow(()->new UsernameNotFoundException("L'utilisateur n'existe pas"));
    }

}
