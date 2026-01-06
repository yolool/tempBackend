package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record PatientDto(
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
        float poids,
        float taille,
        String groupeSanguin,
        String alergies,
        String maladiesChroniques,
        String couvertureMedicale,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}