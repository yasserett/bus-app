package com.yasser.busapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.LocalTime;

@Entity @Data @NoArgsConstructor
public class Position {
    @Id @GeneratedValue
    private int id;
    @Column(columnDefinition = "point")
    private Point location;
    private LocalTime time;
    @ManyToOne(cascade = CascadeType.ALL)
    private Trajet trajet;
}
