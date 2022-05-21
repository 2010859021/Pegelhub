package com.stm.pegelhub.data;

import lombok.Data;


@Data
public class Taker extends  IdentifiableEntity{
    private String stationNumber;
    private Integer stationId;
    private Integer stationChannel;
    private String channelUse;
    private String refreshRate;
    private TakerServiceManufacturer takerServiceManufacturer;
    private Connector connector;
    private Contact takerContact;
    private Contact endUser;
    private Contact dataNetworkOperator;
}
