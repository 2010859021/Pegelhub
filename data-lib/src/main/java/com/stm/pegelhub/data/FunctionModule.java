package com.stm.pegelhub.data;

import javax.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="FunctionModule")
public class FunctionModule extends  IdentifiableEntity{

    @ManyToOne
    @JoinColumn(nullable = false)
    private Connector connector;

    @Column(nullable = false)
    private String refreshRate;
}
