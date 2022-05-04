package com.stm.pegelhub.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

import java.util.UUID;

@Entity
@Data
@Table(name="Supplier")
public class Supplier extends IdentifiableEntity {

    @Column(name= "",nullable = false)
    private String stationNumber;

    @Column(name= "",nullable = false)
    private String stationNation;

    @Column(name= "",nullable = false)
    private String stationOwner;

    @Column(name= "",nullable = false)
    private Integer stationId;

    @Column(name= "",nullable = false)
    private Integer stationChannel;

    @Column(name= "",nullable = false)
    private String channelUse;

    // FK to stationmanufacturer
    @Column( name= "",nullable = false)
    private UUID stationManufacturerId;

    // FK to connector table
    @Column( name= "",nullable = false)
    private UUID connectorId;

    @Column(name= "",nullable = false)
    private String refreshRate;

    @Column(name= "",nullable = false)
    private String accuracy;

    @Column(name= "",nullable = false)
    private String mainUsage;

    @Column(name= "",nullable = false)
    private String dataCritically;

    @Column(name= "",nullable = false)
    private String stationNameLong;

    @Column(name= "",nullable = false)
    private String stationNameShort;

    @Column(name= "",nullable = false)
    private String stationWaterShort;

    @Column(name= "",nullable = false)
    private String stationWaterLong;

    @Column(name= "",nullable = false)
    private String stationWaterType;

    @Column(name= "",nullable = false)
    private Double measurementAccuracy;


    //Timestamp  annontation
    @Column(name= "",nullable = false)
    private Date timestamp;

    @Column(name= "",nullable = false)
    private Boolean isSummertime;

    @Column(name= "",nullable = false)
    private Boolean utcIsUsed;

    @Column(name= "",nullable = false)
    private String kindOfTime;

    // info data

    // FK to contact table
    @Column(name= "")
    private UUID authorizedContactId;

    // FK to contact table
    @Column(name= "")
    private UUID operatorId;

    // FK to contact table
    @Column(name= "")
    private UUID dataNetworkOperatorId;

    @Column(name= "")
    private Double stationBaseReferenceLevel;

    @Column(name= "")
    private String stationReferencePlace;

    @Column(name= "")
    private Double stationWaterKilometer;

    @Column(name= "")
    private String stationWaterside;

    @Column(name= "")
    private Double stationWaterLatitude;

    @Column(name= "")
    private Double stationWaterLongitude;

    @Column(name= "")
    private Double stationWaterLatitudem;

    @Column(name= "")
    private Double stationWaterLongtitudem;

    // warte auf Johannes Feedback bezüglich der englischen Bezeichnungen
    @Column(name = "hsw_100")
    private Integer hsw100;

    @Column(name= "")
    private Integer hsw;

    @Column(name= "")
    private String hswBezug;

    @Column(name= "")
    private Integer mw;

    @Column(name= "")
    private String mwBezug;

    @Column(name= "")
    private Integer rnw;

    @Column(name= "")
    private String rnwBezug;

    @Column(name= "")
    private Double hsq100;

    @Column(name= "")
    private Double hsq;

    @Column(name= "")
    private Double mq;

    @Column(name= "")
    private Double rnq;

}
