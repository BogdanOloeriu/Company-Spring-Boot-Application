package com.sda.company.configuration;

import com.sda.company.utils.CustomFakerCompany;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomFakerCompany customFakerCompany(){
        return new CustomFakerCompany();
    }



}
