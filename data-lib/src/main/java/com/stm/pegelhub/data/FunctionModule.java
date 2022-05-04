package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="Function_Module")
public class FunctionModule extends  IdentifiableEntity{

    //FK to connector table
    @Column(name= "",nullable = false)
    private UUID connectorId;

    @Column(name= "",nullable = false)
    private String refreshRate;
}
