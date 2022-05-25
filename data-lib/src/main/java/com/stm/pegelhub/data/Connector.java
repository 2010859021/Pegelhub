package com.stm.pegelhub.data;

import lombok.Data;

import java.util.UUID;


@Data
public class Connector extends IdentifiableEntity {
    private Contact manufacturer;
    private String typeDescription;
    private Double softwareVersion;
    private Double worksFromDataVersion;
    private String dataDefinition;
    private Contact softwareManufacturer;
    private Contact technicallyResponsible;
    private Contact operatingCompany;
    private String nodes;

    public Connector(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public Connector() {
    }
}
