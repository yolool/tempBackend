package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record RendezVousDto(
        int id,
        LocalDateTime date,
        String statut,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}