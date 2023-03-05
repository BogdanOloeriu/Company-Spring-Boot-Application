package com.sda.company.service;

import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.dto.CompanyLiteDTO;
import com.sda.company.model.CompanyEntity;

import java.util.List;

public interface CompanyService {

     CompanyInfoDTO createCompany(CompanyCreateDTO companyCreateDTO);

     CompanyInfoDTO getCompanyByName(String name);

     void generateCompanies();

     List<CompanyLiteDTO> getCompanies(Integer pageNumber, Integer pageSize, String sortBy);
}
