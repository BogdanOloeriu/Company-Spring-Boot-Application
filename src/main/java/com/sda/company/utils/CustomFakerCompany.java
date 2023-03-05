package com.sda.company.utils;

import com.github.javafaker.Faker;
import com.sda.company.model.CompanyEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerCompany {

    public List<CompanyEntity> generateDummyCompany (){

        List<CompanyEntity> companyEntities = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i< 100; i++){
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setName(faker.company().name());
            companyEntity.setAddress(faker.address().fullAddress());
            companyEntity.setEmail(faker.bothify("?????##@company.com"));
            companyEntity.setPhoneNumber(faker.phoneNumber().phoneNumber());
            companyEntity.setRegistrationNumber(faker.number().randomNumber(5,true));

            companyEntities.add(companyEntity);
        }
        return companyEntities;
    }
}
