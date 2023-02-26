package com.sda.company.repository;

import com.sda.company.model.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //nu este obligatoriu sa mai pui adntarea asta
public interface CompanyRepository  extends CrudRepository<CompanyEntity,Integer> {
}
