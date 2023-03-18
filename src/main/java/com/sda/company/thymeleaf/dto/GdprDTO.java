package com.sda.company.thymeleaf.dto;

public class GdprDTO {

    private String name;
    private boolean gdprConsent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGdprConsent() {
        return gdprConsent;
    }

    public void setGdprConsent(boolean gdprConsent) {
        this.gdprConsent = gdprConsent;
    }
}
