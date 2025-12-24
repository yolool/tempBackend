package com.project.emedcare.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient extends Utilisateur {
    private float poids;
    private float taille;
    private String groupeSanguin;
    private String allergies;
    private String maladiesChroniques;
    private String couvertureMedicale;

    @OneToOne(mappedBy = "patient")
    private DossierMedical dossierMedical;
}
