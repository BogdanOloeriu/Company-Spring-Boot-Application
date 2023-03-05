package com.sda.company.controller;


import com.sda.company.exception.CompanyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //trebuie adnotata asa
public class ControllerAdvisor extends ResponseEntityExceptionHandler { //extindem ResonseEntityException pt ca toate sunt imbracate in acest response entity

    @ExceptionHandler(CompanyException.class) //cand pornim aplicatia, spring va sti ca , clasa e adviso si meoda e handlerul
    public ResponseEntity<Object> handleCompanyException(CompanyException companyException){

        // va trebuie sa cnstruim un map, practic va trebuie sa constuim un obiect, va fi convertit in json la un momendat.
        Map<String,Object> responseBody = new HashMap<>();
        responseBody.put("timeStamp", LocalDate.now()); //scopul e sa vedem cand s a intamplat exceptia
        responseBody.put("errorMessage",companyException.getMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_ACCEPTABLE);

    }

}
