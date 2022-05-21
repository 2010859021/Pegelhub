package com.stm.pegelhub.data;


import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public abstract class IdentifiableEntity implements Serializable {
    private UUID id;
}
