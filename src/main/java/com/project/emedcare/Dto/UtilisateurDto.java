package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record UtilisateurDto(
        int id,
        String email,
        String role,
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
