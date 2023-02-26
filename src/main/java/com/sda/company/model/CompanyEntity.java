package com.sda.company.model;

import jakarta.persistence.*;

@Entity
public class CompanyEntity {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(unique = true) //ca sa l facem unic
    private Long registrationNumber;

    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String phoneNumber;

    public CompanyEntity() {
    }

    public CompanyEntity(String name, Long registrationNumber, String email, String address, String phoneNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
