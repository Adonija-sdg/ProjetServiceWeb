package com.example.isge.ProjetServiceWeb.mapper;

import com.example.isge.ProjetServiceWeb.dto.CorrectionParJourDto;
import com.example.isge.ProjetServiceWeb.entity.CorrectionParJour;

import java.time.LocalDate;


public class CorrectionParJourDtoMapper {

    public static CorrectionParJourDto toCorrectionParJourDto(CorrectionParJour correctionParJour) {
        CorrectionParJourDto correctionParJourDto = new CorrectionParJourDto();
        correctionParJourDto.setId_correction(correctionParJour.getId_correction());
        correctionParJourDto.setDateSaisie(correctionParJour.getDateSaisie());
        // Vous pouvez ajouter d'autres mappings selon vos besoins
        return correctionParJourDto;
    }

    public static CorrectionParJour toCorrectionParJour(CorrectionParJourDto correctionParJourDto) {
        CorrectionParJour correctionParJour = new CorrectionParJour();
        correctionParJour.setDateSaisie(LocalDate.now());
        // Vous pouvez ajouter d'autres mappings selon vos besoins
        return correctionParJour;
    }
}
