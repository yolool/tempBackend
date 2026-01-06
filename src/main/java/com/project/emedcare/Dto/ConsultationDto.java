package com.project.emedcare.Dto;

import java.time.LocalDateTime;

public record ConsultationDto(
        int id,
        LocalDateTime date,
        String motif,
        String rapport,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}
