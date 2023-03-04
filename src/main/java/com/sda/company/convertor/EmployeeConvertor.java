package com.sda.company.convertor;

import com.sda.company.dto.EmployeeRequestDTO;
import com.sda.company.dto.EmployeeResponseDTO;
import com.sda.company.model.EmployeeEntity;

public class EmployeeConvertor {

    public static EmployeeEntity convertToEmployeeEntity(EmployeeRequestDTO employeeRequestDTO) {
        return new EmployeeEntity(
                employeeRequestDTO.getName(),
                employeeRequestDTO.getPhoneNumber(),
                employeeRequestDTO.getCNP(),
                employeeRequestDTO.getEmail(),
                employeeRequestDTO.getAddress(),
                employeeRequestDTO.getJobTitle(),
                employeeRequestDTO.getSalary()
        );
    }

    public static EmployeeResponseDTO convertEntityToEmployeeResponseDTO(EmployeeEntity employeeEntity) {
        return new EmployeeResponseDTO(
                employeeEntity.getId(),
                employeeEntity.getName(),
                employeeEntity.getPhoneNumber(),
                employeeEntity.getCNP(),
                employeeEntity.getEmail(),
                employeeEntity.getAddress(),
                employeeEntity.getJobTitle(),
                employeeEntity.getSalary()
        );
    }
}
