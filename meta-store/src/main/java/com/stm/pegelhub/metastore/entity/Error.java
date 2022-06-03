package com.stm.pegelhub.metastore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name="Error")
public class Error {
    @EmbeddedId @JsonIgnore
    private ErrorPrimaryKey primaryKey;

    @Lob
    @Column(nullable = false)
    private String plaintext;

    @ManyToOne
    @JoinColumn(nullable = false)
    @MapsId("takerServiceManufacturerId")
    private TakerServiceManufacturer takerServiceManufacturer;

    public String getErrorCode() {
        return primaryKey.getErrorCode();
    }

//    public UUID getTakerServiceManufacturer() {
//        return primaryKey.getTakerServiceManufacturerId();
//    }

    public void setErrorCode(String errorCode) {
        if (primaryKey == null) this.primaryKey = new ErrorPrimaryKey();
        this.primaryKey.setErrorCode(errorCode);
    }

    public void setTakerServiceManufacturer(UUID uuid) {
        if (primaryKey == null) this.primaryKey = new ErrorPrimaryKey();
        this.primaryKey.setTakerServiceManufacturerId(uuid);
        this.takerServiceManufacturer = new TakerServiceManufacturer();
        this.takerServiceManufacturer.setId(uuid);
    }

    @Embeddable @Data
    public static final class ErrorPrimaryKey implements Serializable {
        private String errorCode;

        private UUID takerServiceManufacturerId;
    }

    public static Error withPrimaryKey(ErrorPrimaryKey pk) {
        Error tmp = new Error();
        tmp.setPrimaryKey(pk);
        return tmp;
    }
}
