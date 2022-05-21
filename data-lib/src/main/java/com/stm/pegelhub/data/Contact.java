package com.stm.pegelhub.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Contact")
public class Contact extends  IdentifiableEntity{

    @Column()
    private String organization;

    @Column()
    private String contactPerson;

    @Column()
    private String contactStreet;

    @Column()
    private String contactPlz;

    @Column()
    private String location;

    @Column()
    private String contactCountry;

    @Column()
    private String emergencyNumber;

    @Column()
    private String emergencyNumberTwo;

    @Column()
    private String emergencyMail;

    @Column()
    private String serviceNumber;

    @Column()
    private String serviceNumberTwo;

    @Column()
    private String serviceMail;

    @Column()
    private String administrationPhoneNumber;

    @Column()
    private String administrationPhoneNumberTwo;

    @Column()
    private String administrationMail;

    @Column()
    @Lob
    private String contactNodes;

}
