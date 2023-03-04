package com.sda.company.service.impl;

import com.sda.company.convertor.EmployeeConvertor;
import com.sda.company.dto.EmployeeRequestDTO;
import com.sda.company.dto.EmployeeResponseDTO;
import com.sda.company.model.EmployeeEntity;
import com.sda.company.repository.EmployeeRepository;
import com.sda.company.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {

        EmployeeEntity employeeEntity = EmployeeConvertor.convertToEmployeeEntity(employeeRequestDTO);
        EmployeeEntity responseEmployeeEntity = employeeRepository.save(employeeEntity);
        return EmployeeConvertor.convertEntityToEmployeeResponseDTO(responseEmployeeEntity);
    }

    @Override
    public EmployeeResponseDTO getById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        return EmployeeConvertor.convertEntityToEmployeeResponseDTO(employeeEntity);
    }

    @Override
    public void delete(Integer id) {
         employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeEntity -> employeeEntities.add(employeeEntity));

        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
        for(EmployeeEntity e : employeeEntities){
            employeeResponseDTOList.add(EmployeeConvertor.convertEntityToEmployeeResponseDTO(e));
        }
        return employeeResponseDTOList;
    }
}
