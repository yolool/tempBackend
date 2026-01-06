package com.project.emedcare.Service;

import com.project.emedcare.Dto.AdministrateurDto;
import com.project.emedcare.Entity.Administrateur;
import com.project.emedcare.Entity.Compte;
import com.project.emedcare.Mapping.AdministrateurMapper;
import com.project.emedcare.Repository.AdminstrateurRepository;
import com.project.emedcare.Repository.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminstrateurService {
    private final AdminstrateurRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final CompteRepository compteRepository;
    private final AdministrateurMapper adminMapper;

    public  AdministrateurDto createAdministrateur(AdministrateurDto adminDto){
        Compte compte = new Compte();
        compte.setEmail(adminDto.email());
        compte.setMotDePasse(passwordEncoder.encode(adminDto.motDePasse()));
        compte.setRole("ADMIN");
        compte.setCurrentdate(LocalDateTime.now()); // Assuming Date or LocalDate
        compte.setStatut("Active");
        compte = compteRepository.save(compte);
        Administrateur admin = adminMapper.ToEntity(adminDto, compte);
        compte.setUtilisateur(admin);
        Administrateur savedAdmin = adminRepository.save(admin);
        return adminMapper.apply(savedAdmin);

     }
    public List<AdministrateurDto> getAllAdministrateurs() {
        return adminRepository.findAll().stream()
                .map(adminMapper)
                .collect(Collectors.toList());

    }
    public AdministrateurDto updateAdministrateur(Long id, AdministrateurDto adminDto) {
        Administrateur existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrateur not found"));
        Compte compte = existingAdmin.getCompte();
        if (adminDto.email() != null) {
            compte.setEmail(adminDto.email());
        }
        if (adminDto.motDePasse() != null) {
            compte.setMotDePasse(passwordEncoder.encode(adminDto.motDePasse()));
        }
        Administrateur a = adminMapper.ToEntity(adminDto, compte);
        a.setId(id);
        Administrateur savedAdmin = adminRepository.save(a);
        return adminMapper.apply(savedAdmin);



}
    public void deleteAdministrateur(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new RuntimeException("Administrateur not found");
        }
         adminRepository.deleteById(id);
    }
    public void ActivateCompte(Long id) {
         adminRepository.ActivateCompte(id);
    }
    public void DesactiverCompte(Long id) {
        adminRepository.DesactiverCompte(id);
    }

}
