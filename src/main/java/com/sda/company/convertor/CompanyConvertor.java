package com.sda.company.convertor;

import com.sda.company.dto.CompanyCreateDTO;
import com.sda.company.dto.CompanyInfoDTO;
import com.sda.company.dto.CompanyLiteDTO;
import com.sda.company.model.CompanyEntity;

import java.util.List;

public class CompanyConvertor {

    public static CompanyEntity convertToCompanyEntity(CompanyCreateDTO companyCreateDTO){
        return new CompanyEntity(
                companyCreateDTO.getName(),
                companyCreateDTO.getRegistrationNumber(),
                companyCreateDTO.getEmail(),
                companyCreateDTO.getAddress(),
                companyCreateDTO.getPhoneNumber());
    }

    public static CompanyInfoDTO convertToCompanyInfoDTO(CompanyEntity companyEntity){
        return new CompanyInfoDTO(
                companyEntity.getId(),
                companyEntity.getName(),
                companyEntity.getRegistrationNumber(),
                companyEntity.getEmail(),
                companyEntity.getAddress(),
                companyEntity.getPhoneNumber());
    }

    public static CompanyLiteDTO convertToCompanyLiteDTO(CompanyEntity companyEntity){
        return new CompanyLiteDTO(
                companyEntity.getName(),
                companyEntity.getEmail(),
                companyEntity.getPhoneNumber());
    }
}
