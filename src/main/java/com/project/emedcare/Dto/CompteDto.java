package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record CompteDto(
        int id,
        String email,
        String motDePasse,
        String role,
        LocalDateTime dateCreationn,
        String statut,
        String image,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}