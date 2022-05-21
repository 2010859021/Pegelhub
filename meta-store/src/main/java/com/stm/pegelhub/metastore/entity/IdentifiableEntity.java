package com.stm.pegelhub.metastore.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@Data @MappedSuperclass
public abstract class IdentifiableEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
}
