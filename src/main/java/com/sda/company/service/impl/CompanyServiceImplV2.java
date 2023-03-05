package com.sda.company.service.impl;

import com.sda.company.convertor.CompanyConvertor;
import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.dto.CompanyLiteDTO;
import com.sda.company.exception.CompanyException;
import com.sda.company.model.CompanyEntity;
import com.sda.company.repository.CompanyRepository;
import com.sda.company.service.CompanyService;
import com.sda.company.utils.CustomFakerCompany;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("companyServiceVersion2")
public class CompanyServiceImplV2 implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CustomFakerCompany customFakerCompany;

    public CompanyServiceImplV2(CompanyRepository companyRepository, CustomFakerCompany customFakerCompany) {
        this.companyRepository = companyRepository;
        this.customFakerCompany = Objects.requireNonNull(customFakerCompany);
    }

    @Override
    public CompanyInfoDTO createCompany(CompanyCreateDTO companyCreateDTO) {

        CompanyEntity companyEntity = CompanyConvertor.convertToCompanyEntity(companyCreateDTO);
        CompanyEntity response = companyRepository.save(companyEntity);
        CompanyInfoDTO companyInfoDTO = CompanyConvertor.convertToCompanyInfoDTO(response);

        return companyInfoDTO;

    }

    @Override
    public CompanyInfoDTO getCompanyByName(String name) {

       //imi trebuie un findByName
        //o vom face noi
        CompanyEntity companyEntity = companyRepository
                .findByName(name)
                .orElseThrow(() -> new CompanyException("Company not found")); //daca nu l gaseste o sa arunce o exceptie

        return CompanyConvertor.convertToCompanyInfoDTO(companyEntity);

    }

    @Override
    public void generateCompanies() {
        List<CompanyEntity> companyEntities = customFakerCompany.generateDummyCompany();
        companyRepository.saveAll(companyEntities);
    }

    @Override
    public List<CompanyLiteDTO> getCompanies(Integer pageNumber, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<CompanyLiteDTO> companyLiteDTOS = new ArrayList<>();

        companyRepository.findAll(pageable).forEach(companyEntity -> {
            companyLiteDTOS.add(CompanyConvertor.convertToCompanyLiteDTO(companyEntity));
        });
        return companyLiteDTOS;
    }
}
