package com.sda.company.controller;

import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.dto.CompanyLiteDTO;
import com.sda.company.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/company")
@ControllerAdvice
//ca sa ne apara mesajul nostru de eroare, dar trebuie sa mai facem noi ceva ca sa se vada si la client mesajul
public class CompanyController {

    private final CompanyService companyService;


    @Autowired //in scop didactic,nu este necesara
    public CompanyController(@Qualifier("companyServiceVersion1") CompanyService companyService) { //ii punem numele cu camel case ca sa i zicem care impl sa foloseasca
        // in locul unde injectam trebuie sa dam si qualifierul
        //poti cu numele de la impl camelcase sau cu numele de la service cand ii dai @Service("name");
        this.companyService = Objects.requireNonNull(companyService);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyInfoDTO> create(@RequestBody @Valid CompanyCreateDTO companyCreateDTO) {
        //TREBUIE SI VALID CA SA IA VALIDARILE DIN DTO
        CompanyInfoDTO companyInfoDTO = companyService.createCompany(companyCreateDTO);
        return ResponseEntity.ok(companyInfoDTO);
    }

    @GetMapping("/findCompanyByName") //vom folosi requestParam
    public ResponseEntity<CompanyInfoDTO> getCompanyByName(@RequestParam String name) {

        CompanyInfoDTO companyInfoDTO = companyService.getCompanyByName(name);

        return ResponseEntity.ok(companyInfoDTO);

        //scopul rapperului ResponseEntity,Optional, -> 1. Un obiect rapper ne aduce niste functionalitati in plus peste un object java
        //                                              2. in cazul nostru, response entity e ca un contract, ne forteaza pe noi sa raspundem cu un status code

    }

    @GetMapping("/generateFakerCompanies")
    public ResponseEntity<String> generateCompanies() {
        companyService.generateCompanies();
        return ResponseEntity.ok("Companies generated!");
    }

    @GetMapping("/findAllCompanies")
    public ResponseEntity<List<CompanyLiteDTO>> getCompanies(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                                             @RequestParam(defaultValue = "name") String sortBy) {
        //folosim default ca in cazul in care nu pune userul,sa aiba aia byDefault;
        return ResponseEntity.ok(companyService.getCompanies(pageNumber, pageSize, sortBy));
    }
}
