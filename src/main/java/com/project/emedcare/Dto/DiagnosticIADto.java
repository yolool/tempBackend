package com.project.emedcare.Dto;

import java.time.LocalDateTime;
import java.util.List;

public record DiagnosticIADto(
        int id,
        LocalDateTime date,
        String symptomes,
        String rresultat,
        LocalDateTime currentdate,
        LocalDateTime updatedate
) {}