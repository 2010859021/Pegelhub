package com.stm.pegelhub.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="Error")
public class Error {
    @Id
    @Column(nullable = false)
    private String errorCode;

    @Lob
    @Column(nullable = false)
    private String plaintext;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private TakerServiceManufacturer takerServiceManufacturer;
}
