package com.project.emedcare.Controller;

import com.project.emedcare.Dto.AdministrateurDto;
import com.project.emedcare.Service.AdminstrateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminstrateurController {
    private final AdminstrateurService adminService;
    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody AdministrateurDto administrateurDto) {
        try{
            AdministrateurDto admin=adminService.createAdministrateur(administrateurDto);
            return new  ResponseEntity<>(admin,HttpStatus.CREATED);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllAdministrateur(){
        try{
            List<AdministrateurDto> admin=adminService.getAllAdministrateurs();
            return new  ResponseEntity<>(admin,HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AdministrateurDto administrateurDto) {
        try{
            AdministrateurDto admin=adminService.updateAdministrateur(id, administrateurDto);
            return new  ResponseEntity<>(admin,HttpStatus.CREATED);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            adminService.deleteAdministrateur(id);
            return new  ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/activer/{id}")
    public ResponseEntity<?> Activate(@PathVariable Long id) {
        try {
            adminService.ActivateCompte(id);
            return new  ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/desactiver/{id}")
    public ResponseEntity<?> Desactiver(@PathVariable Long id) {
        try {
            adminService.DesactiverCompte(id);
            return new  ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
