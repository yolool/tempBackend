package com.project.emedcare.Mapping;

import com.project.emedcare.Dto.AdministrateurDto;
import com.project.emedcare.Entity.Administrateur;

import java.time.LocalDateTime;
import java.util.function.Function;

import com.project.emedcare.Entity.Compte;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurMapper implements Function<Administrateur, AdministrateurDto> {


    @Override
    public AdministrateurDto apply(Administrateur administrateur) {
     return new AdministrateurDto(
             administrateur.getId(),
             administrateur.getCompte().getEmail(),
             null,
             administrateur.getNom(),
             administrateur.getPrenom(),
             administrateur.getDateNaissance(),
             administrateur.getSexe(),
             administrateur.getTelephone(),
             administrateur.getAdresse(),
             administrateur.getPhotoProfil(),
             administrateur.getCIN(),
             administrateur.getNumeroLicence(),
             administrateur.getCurrentdate(),
             administrateur.getUpdatedate()
     ) ;
    }
   public Administrateur ToEntity(AdministrateurDto administrateurDto, Compte compte) {
        Administrateur admin = new Administrateur();
        admin.setCompte(compte);
        admin.setNom(administrateurDto.nom());
        admin.setPrenom(administrateurDto.prenom());
        admin.setDateNaissance(administrateurDto.dateNaissancce());
        admin.setSexe(administrateurDto.sexe());
        admin.setTelephone(administrateurDto.telephone());
        admin.setAdresse(administrateurDto.adresse());
        admin.setPhotoProfil(administrateurDto.photoProfil());
        admin.setCIN(administrateurDto.CIN());
        admin.setNumeroLicence(administrateurDto.numeroLicence());
        admin.setCurrentdate(LocalDateTime.now());
        admin.setUpdatedate(LocalDateTime.now());
        return admin;
   }
}
