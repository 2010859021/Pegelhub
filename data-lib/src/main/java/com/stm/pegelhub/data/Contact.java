package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Contact")
public class Contact extends  IdentifiableEntity{

    @Column(name= "")
    private String organization;

    @Column(name= "")
    private String contactPerson;

    @Column(name= "")
    private String contactStreet;

    @Column(name= "")
    private String contactPlz;

    @Column(name= "")
    private String location;

    @Column(name= "")
    private String contactCountry;

    @Column(name= "")
    private String emergencyNumber;

    @Column(name= "")
    private String emergencyNumberTwo;

    @Column(name= "")
    private String emergencyMail;

    @Column(name= "")
    private String serviceNumber;

    @Column(name= "")
    private String serviceNumberTwo;

    @Column(name= "")
    private String serviceMail;

    @Column(name= "")
    private String administrationPhoneNumber;

    @Column(name= "")
    private String administrationPhoneNumberTwo;

    @Column(name= "")
    private String administrationMail;

    @Column(name= "")
    private String contactNodes;

}
