package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Data
@Table(name="Taker")
public class Taker extends IdentifiableEntity {

    @Column(nullable = false)
    private String stationNumber;

    @Column(nullable = false)
    private Integer stationId;

    @Column(nullable = false)
    private Integer stationChannel;

    @Column(nullable = false)
    private String channelUse;

    @Column(nullable = false)
    private String refreshRate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TakerServiceManufacturer takerServiceManufacturer;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Connector connector;

    @ManyToOne
    @JoinColumn()
    private Contact takerContact;

    @ManyToOne
    @JoinColumn()
    private Contact endUser;

    @ManyToOne
    @JoinColumn()
    private Contact dataNetworkOperator;

    public Taker(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public Taker() {
    }
}
