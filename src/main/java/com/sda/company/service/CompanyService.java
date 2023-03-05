package com.sda.company.service;

import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.model.CompanyEntity;

import java.util.List;

public interface CompanyService {

     CompanyInfoDTO createCompany(CompanyCreateDTO companyCreateDTO);

     CompanyInfoDTO getCompanyByName(String name);

     void generateCompanies();
}
