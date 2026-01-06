package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record DossierMedicalDto(
        int id,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}