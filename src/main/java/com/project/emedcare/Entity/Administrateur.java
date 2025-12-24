package com.project.emedcare.Entity;



import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Administrateur extends Utilisateur {
    private String numeroLicence;
}
