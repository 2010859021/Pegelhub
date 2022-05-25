package com.stm.pegelhub.data;

import lombok.Data;

import java.util.UUID;

@Data
public class Contact extends  IdentifiableEntity{
    private String organization;
    private String contactPerson;
    private String contactStreet;
    private String contactPlz;
    private String location;
    private String contactCountry;
    private String emergencyNumber;
    private String emergencyNumberTwo;
    private String emergencyMail;
    private String serviceNumber;
    private String serviceNumberTwo;
    private String serviceMail;
    private String administrationPhoneNumber;
    private String administrationPhoneNumberTwo;
    private String administrationMail;
    private String contactNodes;

    public Contact() {
    }

    public Contact(String id) {
        this.setId(UUID.fromString(id));
    }
}
