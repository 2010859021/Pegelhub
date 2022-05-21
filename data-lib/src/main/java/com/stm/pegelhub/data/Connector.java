package com.stm.pegelhub.data;

import lombok.Data;


@Data
public class Connector extends IdentifiableEntity {
    private Contact manufacturerId;
    private String typeDescription;
    private Double softwareVersion;
    private Double worksFromDataVersion;
    private String dataDefinition;
    private Contact softwareManufacturerId;
    private Contact technicallyResponsibleId;
    private Contact operatingCompanyId;
    private String nodes;
}
