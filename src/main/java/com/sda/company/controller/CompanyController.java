package com.sda.company.controller;

import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/company")
@ControllerAdvice  //ca sa ne apara mesajul nostru de eroare, dar trebuie sa mai facem noi ceva ca sa se vada si la client mesajul
public class CompanyController {

    private final CompanyService companyService;

    @Autowired //in scop didactic,nu este necesara
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyInfoDTO> create(@RequestBody @Valid CompanyCreateDTO companyCreateDTO){
        //TREBUIE SI VALID CA SA IA VALIDARILE DIN DTO
        CompanyInfoDTO companyInfoDTO =  companyService.createCompany(companyCreateDTO);
        return ResponseEntity.ok(companyInfoDTO);
    }

}
