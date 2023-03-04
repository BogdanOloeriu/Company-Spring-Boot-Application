package com.sda.company.service;


import com.sda.company.dto.EmployeeRequestDTO;
import com.sda.company.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

     EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);

     EmployeeResponseDTO getById(Integer id);

     void delete(Integer id);

     List<EmployeeResponseDTO> getAllEmployee();
}
