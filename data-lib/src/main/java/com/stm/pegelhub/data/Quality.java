package com.stm.pegelhub.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Quality")
public class Quality extends  IdentifiableEntity{

    @Column(nullable = false)
    private Integer qualityCode;

    @Column(nullable = false)
    @Lob
    private String plaintext;
}
