package com.project.emedcare.Dto;

import java.time.*;

public record AdministrateurDto(
        Long id,
        String email,
        String motDePasse,
        String nom,
        String prenom,
        LocalDate dateNaissancce,
        String sexe,
        String telephone,
        String adresse,
        String photoProfil,
        String CIN,
        String numeroLicence,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}
