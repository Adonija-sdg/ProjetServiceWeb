package com.example.isge.ProjetServiceWeb.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorrectionParJourDto {

    private Long id_correction;

    private LocalDate dateSaisie;

    private CorrectionParJourDto correctionParJourDto;
}
