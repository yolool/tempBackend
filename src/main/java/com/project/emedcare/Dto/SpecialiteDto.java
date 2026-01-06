package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record SpecialiteDto(
        int id,
        String nom,
        String descriptionn,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}
