package com.stm.pegelhub.data;

import lombok.Data;

import java.util.UUID;


@Data
public class FunctionModule extends  IdentifiableEntity{
    private Connector connector;

    public FunctionModule(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public FunctionModule() {
    }

    private String refreshRate;
}
