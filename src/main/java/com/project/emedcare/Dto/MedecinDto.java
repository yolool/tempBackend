package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record MedecinDto(
        int id,
        String email,
        String nom,
        String prenom,
        LocalDateTime dateNaissancce,
        String sexe,
        String telephone,
        String adresse,
        String photoProfil,
        String CIN,
        String numeroLicence,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}