package com.sda.company.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String ROL_USER = "USER";
    private static final String ROL_ADMIN = "ADMIN";
    private static final String ROL_POWER_USER = "POWER_USER";

    @Bean
    @Primary //ca sa fiu sigur ca spring o instantiaza pe asta prima, si dupa ce face password nu va mai da NullPointEception!!!
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //poate exista si cu 3 beanuri care depindi de ele, daca nu poti sa rezolvi cu primary chestia asta,poti sa faci altfel:
    //e de preferat sa ti faci alta clasa de config
    //izolez beanurile care tin de in base memory de altele,adica le fac in alta clasa de config

    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder().encode("1234")) //parola asta e un Bean, beanurile sunt niste metode care sunt incarcate in IOC cand dai start
                .roles(ROL_USER)
                .build());

        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles(ROL_ADMIN)
                .build());

        manager.createUser(User.withUsername("powerUser")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles(ROL_POWER_USER, ROL_USER, ROL_ADMIN)
                .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception { //asta primeste un input de tip https!

        //acest filter chain, fiecare enddpoint trebuie securizat, aici o sa i spunem cine si unde are acces.

        httpSecurity.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/api/v1/company/create").hasRole(ROL_ADMIN);
            auth.requestMatchers("/api/v1/company/findCompanyByName").hasRole(ROL_USER);
            auth.requestMatchers("/api/v1/company/generateFakerCompanies").hasRole(ROL_POWER_USER);
            auth.requestMatchers("/api/v1/company/findAllCompanies").hasRole(ROL_POWER_USER);
        }).httpBasic();

        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .and()
                .cors()
                .disable()
                .authorizeHttpRequests();

        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){

        return (web) ->
                web.
                ignoring().
                requestMatchers("/images/**", "/js/**", "/webjars/**");
    }

}
