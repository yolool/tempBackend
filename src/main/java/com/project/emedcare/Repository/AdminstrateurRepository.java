package com.project.emedcare.Repository;

import com.project.emedcare.Entity.Administrateur;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AdminstrateurRepository extends JpaRepository<Administrateur,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Compte c set c.statut='Active' where c.id=:id ")
    public void ActivateCompte(Long id);
    @Modifying
    @Transactional
    @Query("UPDATE Compte c set c.statut='Desactiver' where c.id=:id")
    public void DesactiverCompte(Long id);
}
