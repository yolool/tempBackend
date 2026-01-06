package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record AssistanteDto(
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
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}