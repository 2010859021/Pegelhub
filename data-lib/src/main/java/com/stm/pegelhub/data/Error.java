package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="Error")
public class Error {

    @Column(name= "",nullable = false)
    private String errorCode;

    @Column(name= "",nullable = false)
    private String plaintext;

    //FK+PK takerServiceManudacturer
    @Column(name= "",nullable = false)
    private UUID takerServiceManufacturerId;
}
