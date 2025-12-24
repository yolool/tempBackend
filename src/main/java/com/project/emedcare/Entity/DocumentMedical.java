package com.project.emedcare.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;
    @CurrentTimestamp
    private LocalDateTime currentdate;
    @UpdateTimestamp
    private LocalDateTime updatedate;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}
