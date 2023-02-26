package com.sda.company.service.impl;

import com.sda.company.convertor.CompanyConvertor;
import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.model.CompanyEntity;
import com.sda.company.repository.CompanyRepository;
import com.sda.company.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyInfoDTO createCompany(CompanyCreateDTO companyCreateDTO) {

        CompanyEntity companyEntity = CompanyConvertor.convertToCompanyEntity(companyCreateDTO);
        CompanyEntity response = companyRepository.save(companyEntity);
        CompanyInfoDTO companyInfoDTO = CompanyConvertor.convertToCompanyInfoDTO(response);

        return companyInfoDTO;

    }
}
