package com.sda.company.repository;

import com.sda.company.model.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //nu este obligatoriu sa mai pui adntarea asta
public interface CompanyRepository  extends CrudRepository<CompanyEntity,Integer>, PagingAndSortingRepository<CompanyEntity,Integer> { //pt paginare nu ne mai ajuta crud repository
    //paging repository deja extinde crud
    //nu ar mai trebui si CRUD, la spring boot 2.0 mergea, acum nu mai merge


    //Crud poate sa traduca el metoda
    //wrapper - un obiect care imbraca un alt obiect
    Optional<CompanyEntity> findByName (String name);


}
