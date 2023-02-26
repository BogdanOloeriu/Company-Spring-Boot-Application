package com.sda.company.service;

import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;

public interface CompanyService {

    public CompanyInfoDTO createCompany(CompanyCreateDTO companyCreateDTO);
}
