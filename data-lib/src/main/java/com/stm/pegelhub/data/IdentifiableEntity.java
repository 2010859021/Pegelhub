package com.stm.pegelhub.data;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
public abstract class IdentifiableEntity {
    @Id @Column(name = "id")
    private UUID id;
}
