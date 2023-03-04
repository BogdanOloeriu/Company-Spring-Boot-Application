package com.sda.company.repository;


import com.sda.company.model.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Integer> {
}
