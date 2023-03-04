package com.sda.company.model;

import jakarta.persistence.*;

@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private java.lang.String name;
    @Column(name = "phone_number")
    private String phoneNumber;

    private Long CNP;
    private String email;
    private String address;

    @Column(name = "job_title")
    private String jobTitle;

    private Long salary;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String phoneNumber, Long CNP, String email, String address, String jobTitle, Long salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.CNP = CNP;
        this.email = email;
        this.address = address;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCNP() {
        return CNP;
    }

    public void setCNP(Long CNP) {
        this.CNP = CNP;
    }

    public java.lang.String getEmail() {
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
