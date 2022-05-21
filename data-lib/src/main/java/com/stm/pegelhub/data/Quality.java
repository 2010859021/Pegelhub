package com.stm.pegelhub.data;

import lombok.Data;

@Data
public class Quality extends  IdentifiableEntity{
    private Integer qualityCode;
    private String plaintext;
}
