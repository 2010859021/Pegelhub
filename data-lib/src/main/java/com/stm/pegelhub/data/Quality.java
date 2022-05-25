package com.stm.pegelhub.data;

import lombok.Data;

import java.util.UUID;

@Data
public class Quality extends  IdentifiableEntity{
    private Integer qualityCode;
    private String plaintext;

    public Quality(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public Quality() {
    }
}
