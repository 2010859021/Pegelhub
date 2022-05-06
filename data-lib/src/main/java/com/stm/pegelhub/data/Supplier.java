package com.stm.pegelhub.data;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
@Table(name = "Supplier")
public class Supplier extends IdentifiableEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Connector connector;

    @ManyToOne
    @JoinColumn(nullable = false)
    private StationManufacturer stationManufacturer;

    @Column(nullable = false)
    private String stationNumber;

    @Column(nullable = false)
    private String stationNation;

    @Column(nullable = false)
    private String stationOwner;

    @Column(nullable = false)
    private Integer stationId;

    @Column(nullable = false)
    private Integer stationChannel;

    @Column(nullable = false)
    private String channelUse;

    @Column(nullable = false)
    private String refreshRate;

    @Column(nullable = false)
    private String accuracy;

    @Column(nullable = false)
    private String mainUsage;

    @Column(nullable = false)
    private String dataCritically;

    @Column(nullable = false)
    private String stationNameLong;

    @Column(nullable = false)
    private String stationNameShort;

    @Column(nullable = false)
    private String stationWaterShort;

    @Column(nullable = false)
    private String stationWaterLong;

    @Column(nullable = false)
    private String stationWaterType;

    @Column(nullable = false)
    private Double measurementAccuracy;


    //Timestamp  annontation
    @Column(nullable = false)
    private Date timestamp;

    @Column(nullable = false)
    private Boolean isSummertime;

    @Column(nullable = false)
    private Boolean utcIsUsed;

    @Column(nullable = false)
    private String kindOfTime;

    // info data

    @ManyToOne
    @JoinColumn()
    private Contact authorizedContact;

    @ManyToOne
    @JoinColumn()
    private Contact operatorId;

    @ManyToOne
    @JoinColumn()
    private Contact dataNetworkOperatorId;

    @Column()
    private Double stationBaseReferenceLevel;

    @Column()
    private String stationReferencePlace;

    @Column()
    private Double stationWaterKilometer;

    @Column()
    private String stationWaterside;

    @Column()
    private Double stationWaterLatitude;

    @Column()
    private Double stationWaterLongitude;

    @Column()
    private Double stationWaterLatitudem;

    @Column()
    private Double stationWaterLongtitudem;

    @Column()
    private Integer hsw100;

    @Column()
    private Integer hsw;

    @Column()
    private String hswReference;

    @Column()
    private Integer mw;

    @Column()
    private String mwReference;

    @Column()
    private Integer rnw;

    @Column()
    private String rnwReference;

    @Column()
    private Double hsq100;

    @Column()
    private Double hsq;

    @Column()
    private Double mq;

    @Column()
    private Double rnq;

}
