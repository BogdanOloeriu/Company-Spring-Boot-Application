package com.sda.company.controller;

import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.model.CompanyEntity;
import com.sda.company.service.CompanyService;
import com.sda.company.utils.CustomFakerCompany;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/company")
@ControllerAdvice  //ca sa ne apara mesajul nostru de eroare, dar trebuie sa mai facem noi ceva ca sa se vada si la client mesajul
public class CompanyController {

    private final CompanyService companyService;


    @Autowired //in scop didactic,nu este necesara
    public CompanyController(CompanyService companyService) {
        this.companyService = Objects.requireNonNull(companyService);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyInfoDTO> create(@RequestBody @Valid CompanyCreateDTO companyCreateDTO){
        //TREBUIE SI VALID CA SA IA VALIDARILE DIN DTO
        CompanyInfoDTO companyInfoDTO =  companyService.createCompany(companyCreateDTO);
        return ResponseEntity.ok(companyInfoDTO);
    }

    @GetMapping("/findCompanyByName") //vom folosi requestParam
    public ResponseEntity<CompanyInfoDTO> getCompanyByName(@RequestParam String name){

        CompanyInfoDTO companyInfoDTO = companyService.getCompanyByName(name);

        return ResponseEntity.ok(companyInfoDTO);

        //scopul rapperului ResponseEntity,Optional, -> 1. Un obiect rapper ne aduce niste functionalitati in plus peste un object java
        //                                              2. in cazul nostru, response entity e ca un contract, ne forteaza pe noi sa raspundem cu un status code

    }

    @GetMapping("/generateFakerCompanies")
    public ResponseEntity<String> generateCompanies(){
        companyService.generateCompanies();
        return ResponseEntity.ok("Companies generated!");
    }



}
