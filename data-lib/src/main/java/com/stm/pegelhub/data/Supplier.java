package com.stm.pegelhub.data;


import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
public class Supplier extends IdentifiableEntity {
    private Connector connector;
    private StationManufacturer stationManufacturer;
    private String stationNumber;
    private String stationNation;
    private String stationOwner;
    private Integer stationId;
    private Integer stationChannel;
    private String channelUse;
    private String refreshRate;
    private String accuracy;
    private String mainUsage;
    private String dataCritically;
    private String stationNameLong;
    private String stationNameShort;
    private String stationWaterShort;
    private String stationWaterLong;
    private String stationWaterType;
    private Double measurementAccuracy;
    private Date timestamp;
    private Boolean isSummertime;
    private Boolean utcIsUsed;
    private String kindOfTime;

    // info data
    private Contact authorizedContact;
    private Contact operatorId;
    private Contact dataNetworkOperatorId;
    private Double stationBaseReferenceLevel;
    private String stationReferencePlace;
    private Double stationWaterKilometer;
    private String stationWaterside;
    private Double stationWaterLatitude;
    private Double stationWaterLongitude;
    private Double stationWaterLatitudem;
    private Double stationWaterLongtitudem;
    private Integer hsw100;
    private Integer hsw;
    private String hswReference;
    private Integer mw;
    private String mwReference;
    private Integer rnw;
    private String rnwReference;
    private Double hsq100;
    private Double hsq;
    private Double mq;
    private Double rnq;

    public Supplier(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public Supplier() {
    }
}
