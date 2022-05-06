package com.stm.pegelhub.data;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public abstract class IdentifiableEntity implements Serializable {
    @Id @Column(name = "id", nullable = false)
    private UUID id;
}
