package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name="Error")
public class Error {
    @EmbeddedId
    private ErrorPrimaryKey primaryKey;

    @Lob
    @Column(nullable = false)
    private String plaintext;

    @ManyToOne
    @JoinColumn(nullable = false)
    @MapsId("takerServiceManufacturerId")
    private TakerServiceManufacturer takerServiceManufacturer;

    @Embeddable @Data
    public static final class ErrorPrimaryKey implements Serializable {
        private String errorCode;

        private UUID takerServiceManufacturerId;
    }
}
