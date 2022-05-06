package com.stm.pegelhub.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Quality")
public class Quality extends  IdentifiableEntity{

    @Column(nullable = false)
    private Double qualityCode;

    @Column(nullable = false)
    @Lob
    private Double plaintext;
}
