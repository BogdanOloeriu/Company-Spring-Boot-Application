package com.sda.company.repository;

import com.sda.company.model.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //nu este obligatoriu sa mai pui adntarea asta
public interface CompanyRepository  extends CrudRepository<CompanyEntity,Integer> {


    //Crud poate sa traduca el metoda
    //wrapper - un obiect care imbraca un alt obiect
    Optional<CompanyEntity> findByName (String name);


}
