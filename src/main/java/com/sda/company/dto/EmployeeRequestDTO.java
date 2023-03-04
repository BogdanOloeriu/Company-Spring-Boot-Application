package com.sda.company.dto;

import com.sda.company.model.JobTitle;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public class EmployeeRequestDTO {

    @NotNull
    private java.lang.String name;

    private java.lang.String phoneNumber;
    @NotNull
    private Long CNP;
    @Email
    private java.lang.String email;
    private java.lang.String address;

    @NotNull
    private JobTitle jobTitle;

    private Long salary;

    public EmployeeRequestDTO(java.lang.String name, java.lang.String phoneNumber, Long CNP, java.lang.String email, java.lang.String address, JobTitle jobTitle, Long salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.CNP = CNP;
        this.email = email;
        this.address = address;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(java.lang.String phoneNumber) {
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

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getAddress() {
        return address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
