package com.stm.pegelhub.data;

import lombok.Data;


@Data
public class FunctionModule extends  IdentifiableEntity{
    private Connector connector;
    private String refreshRate;
}
