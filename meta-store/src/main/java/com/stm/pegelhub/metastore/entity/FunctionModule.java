package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="FunctionModule")
public class FunctionModule extends IdentifiableEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Connector connector;

    @Column(nullable = false)
    private String refreshRate;

    public FunctionModule(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public FunctionModule() {
    }
}
