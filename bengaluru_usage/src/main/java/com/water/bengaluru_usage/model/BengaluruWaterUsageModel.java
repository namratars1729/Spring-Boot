package com.water.bengaluru_usage.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "bengaluruwaterusage")
@NoArgsConstructor
public class BengaluruWaterUsageModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "wardNumber")
    private String wardNumber;

    @Column(name = "wardName")
    private String wardName;

    @Column(name = "averageUsageML")
    private Integer avgMl;

    @Column(name = "geom")
    private Point geom;
}
