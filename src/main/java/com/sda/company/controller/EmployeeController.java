package com.sda.company.controller;

import com.sda.company.dto.EmployeeRequestDTO;
import com.sda.company.dto.EmployeeResponseDTO;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        EmployeeResponseDTO employeeResponseDTO = employeeService.createEmployee(employeeRequestDTO);
        return ResponseEntity.ok(employeeResponseDTO);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployee(){
        List<EmployeeResponseDTO> employeeResponseDTOList = employeeService.getAllEmployee();

        return ResponseEntity.ok(employeeResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmplyeeEntityById(@PathVariable Integer id){
        EmployeeResponseDTO employeeResponseDTO = employeeService.getById(id);
        return ResponseEntity.ok(employeeResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
         employeeService.delete(id);
         return ResponseEntity.ok().build();
    }
}
