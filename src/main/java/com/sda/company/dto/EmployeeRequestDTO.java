package com.sda.company.dto;

import com.sda.company.model.JobTitle;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public class EmployeeRequestDTO {

    @NotNull
    private String name;

    private String phoneNumber;
    @NotNull
    private Long CNP;
    @Email
    private String email;
    private String address;

    @NotNull
    private JobTitle jobTitle;

    private Long salary;

    public EmployeeRequestDTO(String name, String phoneNumber, Long CNP, String email, String address, JobTitle jobTitle, Long salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.CNP = CNP;
        this.email = email;
        this.address = address;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getName() {
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
