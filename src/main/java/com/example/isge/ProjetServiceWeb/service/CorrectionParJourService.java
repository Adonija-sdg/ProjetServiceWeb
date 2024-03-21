package com.example.isge.ProjetServiceWeb.service;

import com.example.isge.ProjetServiceWeb.dto.CorrectionParJourDto;
import com.example.isge.ProjetServiceWeb.entity.CorrectionParJour;
import com.example.isge.ProjetServiceWeb.mapper.CorrectionParJourDtoMapper;
import com.example.isge.ProjetServiceWeb.repository.CorrectionParJourRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CorrectionParJourService {

    @Autowired
    CorrectionParJourRepository correctionParJourRepository;

    public void enregistrementDansLaBaseDonnees(CorrectionParJourDto correctionParJourDto) {
        CorrectionParJour correctionParJour = CorrectionParJourDtoMapper.toCorrectionParJour(correctionParJourDto);
        correctionParJourRepository.save(correctionParJour);
    }

    public void retirerDeLaBaseDeDonnee(long id_correction) {

        correctionParJourRepository.deleteById(id_correction);
    }

    public void modificationDansLaBaseDeDonnees(Long idCorrection, CorrectionParJourDto correctionParJourDto) {
        Optional<CorrectionParJour> optionalCorrectionParJour = correctionParJourRepository.findById(idCorrection);
        if (optionalCorrectionParJour.isPresent()) {
            CorrectionParJour correctionParJour = optionalCorrectionParJour.get();
            // Mettre à jour les informations de la correction avec les données du DTO
            correctionParJour.setDateSaisie(correctionParJourDto.getDateSaisie());
            // Mettre à jour d'autres attributs si nécessaire
            correctionParJourRepository.save(correctionParJour);
        } else {
            // Gérer le cas où la correction n'est pas trouvée
            // Vous pouvez lever une exception ou gérer autrement selon votre logique métier
        }
    }

    public CorrectionParJourDto obtenirUtilisateurParId(Long id) {
        Optional<CorrectionParJour> optionalCorrectionParJour = correctionParJourRepository.findById(id);
        return optionalCorrectionParJour.map(CorrectionParJourDtoMapper::toCorrectionParJourDto).orElse(null);
    }

    public List<CorrectionParJourDto> obtenirTousLesUtilisateurs() {
        List<CorrectionParJour> corrections = correctionParJourRepository.findAll();
        return corrections.stream()
                .map(CorrectionParJourDtoMapper::toCorrectionParJourDto)
                .collect(Collectors.toList());

    }
}
