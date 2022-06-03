package com.stm.pegelhub.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class Error {
    private String errorCode;
    private TakerServiceManufacturer takerServiceManufacturer;
    private String plaintext;

    @JsonIgnore
    public String createKey() {
        return this.getTakerServiceManufacturer().getId().toString() + ":" + this.getErrorCode();
    }

    public void updateFromId(String id) {
        String[] parts = id.split(":");
        this.setTakerServiceManufacturer(new TakerServiceManufacturer());
        this.getTakerServiceManufacturer().setId(UUID.fromString(parts[0]));
        this.setErrorCode(parts[1]);
    }

    public static Error createFromId(String id) {
        Error error = new Error();
        String[] parts = id.split(":");
        error.setTakerServiceManufacturer(new TakerServiceManufacturer());
        error.getTakerServiceManufacturer().setId(UUID.fromString(parts[0]));
        error.setErrorCode(parts[1]);
        return error;
    }
}
