package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record DocumentMedicalDto(
        int id,
        String nom,
        String type,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}
