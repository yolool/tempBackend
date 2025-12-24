package com.project.emedcare.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Assistante extends Utilisateur {
    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;
}
